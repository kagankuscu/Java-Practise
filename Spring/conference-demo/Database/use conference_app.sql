use conference_app

CREATE TABLE attendees
(
    attendee_id  INT NOT NULL IDENTITY PRIMARY KEY,
    first_name   varchar(30) NOT NULL,
    last_name    varchar(30) NOT NULL,
    title        varchar(40) NULL,
    company      varchar(50) NULL,
    email        varchar(80) NOT NULL,
    phone_number varchar(20) NULL
);

CREATE TABLE ticket_types
(
    ticket_type_code  varchar(1) PRIMARY KEY,
    ticket_type_name  varchar(30)  NOT NULL,
    [description]       varchar(100) NOT NULL,
    includes_workshop bit    NOT NULL
);

CREATE TABLE pricing_categories
(
    pricing_category_code varchar(1) PRIMARY KEY,
    pricing_category_name varchar(20) NOT NULL,
    pricing_start_date    date        NOT NULL,
    pricing_end_date      date        NOT NULL
);

CREATE TABLE ticket_prices
(
    ticket_price_id       INT NOT NULL IDENTITY PRIMARY KEY,
    ticket_type_code      varchar(1)    NOT NULL,
    pricing_category_code varchar(1)    NOT NULL,
    base_price            numeric(8, 2) NOT NULL
);

CREATE TABLE discount_codes
(
    discount_code_id INT NOT NULL IDENTITY PRIMARY KEY,
    discount_code    varchar(20)   NOT NULL,
    discount_name    varchar(30)   NOT NULL,
    discount_type    varchar(1)    NOT NULL,
    discount_amount  numeric(8, 2) NOT NULL
);

CREATE TABLE attendee_tickets
(
    attendee_ticket_id INT NOT NULL IDENTITY PRIMARY KEY,
    attendee_id        int       NOT NULL,
    ticket_price_id    int       NOT NULL ,
    discount_code_id   int       NULL ,
    net_price          numeric(8, 2) NOT NULL
);

CREATE TABLE time_slots
(
    time_slot_id         INT NOT NULL IDENTITY PRIMARY KEY,
    time_slot_date       date                   NOT NULL,
    start_time           time NOT NULL,
    end_time             time NOT NULL,
    is_keynote_time_slot bit default 0  NOT NULL
);

CREATE TABLE sessions
(
    session_id          INT NOT NULL IDENTITY PRIMARY KEY,
    session_name        varchar(80)   NOT NULL,
    session_description varchar(1024) NOT NULL,
    session_length      int       NOT NULL
);

CREATE TABLE session_schedule
(
    schedule_id  INT NOT NULL IDENTITY PRIMARY KEY,
    time_slot_id int     NOT NULL ,
    session_id   int     NOT NULL ,
    room         varchar(30) NOT NULL
);

CREATE TABLE tags
(
    tag_id      INT NOT NULL IDENTITY PRIMARY KEY,
    description varchar(30) NOT NULL
);

CREATE TABLE session_tags
(
    session_id int NOT NULL ,
    tag_id     int NOT NULL 
);

CREATE TABLE speakers
(
    speaker_id    INT NOT NULL IDENTITY PRIMARY KEY,
    first_name    varchar(30)   NOT NULL,
    last_name     varchar(30)   NOT NULL,
    title         varchar(40)   NOT NULL,
    company       varchar(50)   NOT NULL,
    speaker_bio   varchar(2000) NOT NULL,
    speaker_photo varchar(max)   NULL
);

CREATE TABLE session_speakers
(
    session_id int NOT NULL ,
    speaker_id int NOT NULL 
);

CREATE TABLE workshops
(
    workshop_id   INT NOT NULL IDENTITY PRIMARY KEY,
    workshop_name varchar(60)   NOT NULL,
    [description]   varchar(1024) NOT NULL,
    requirements  varchar(1024) NOT NULL,
    room          varchar(30)   NOT NULL,
    capacity      int       NOT NULL
);

CREATE TABLE workshop_speakers
(
    workshop_id int NOT NULL ,
    speaker_id  int NOT NULL 
);

CREATE TABLE workshop_registrations
(
    workshop_id        int NOT NULL ,
    attendee_ticket_id int NOT NULL 
);