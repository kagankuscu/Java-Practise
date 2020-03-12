USE [master]
GO
/****** Object:  Database [conference_app]    Script Date: 3/10/2020 10:47:23 PM ******/
CREATE DATABASE [conference_app]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'conference_app', FILENAME = N'/var/opt/mssql/data/conference_app.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'conference_app_log', FILENAME = N'/var/opt/mssql/data/conference_app_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [conference_app] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [conference_app].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [conference_app] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [conference_app] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [conference_app] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [conference_app] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [conference_app] SET ARITHABORT OFF 
GO
ALTER DATABASE [conference_app] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [conference_app] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [conference_app] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [conference_app] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [conference_app] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [conference_app] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [conference_app] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [conference_app] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [conference_app] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [conference_app] SET  ENABLE_BROKER 
GO
ALTER DATABASE [conference_app] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [conference_app] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [conference_app] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [conference_app] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [conference_app] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [conference_app] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [conference_app] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [conference_app] SET RECOVERY FULL 
GO
ALTER DATABASE [conference_app] SET  MULTI_USER 
GO
ALTER DATABASE [conference_app] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [conference_app] SET DB_CHAINING OFF 
GO
ALTER DATABASE [conference_app] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [conference_app] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [conference_app] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'conference_app', N'ON'
GO
ALTER DATABASE [conference_app] SET QUERY_STORE = OFF
GO
USE [conference_app]
GO
/****** Object:  Table [dbo].[attendee_tickets]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[attendee_tickets](
	[attendee_ticket_id] [int] IDENTITY(1,1) NOT NULL,
	[attendee_id] [int] NOT NULL,
	[ticket_price_id] [int] NOT NULL,
	[discount_code_id] [int] NULL,
	[net_price] [numeric](8, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[attendee_ticket_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[attendees]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[attendees](
	[attendee_id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](30) NOT NULL,
	[last_name] [varchar](30) NOT NULL,
	[title] [varchar](40) NULL,
	[company] [varchar](50) NULL,
	[email] [varchar](80) NOT NULL,
	[phone_number] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[attendee_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[discount_codes]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[discount_codes](
	[discount_code_id] [int] IDENTITY(1,1) NOT NULL,
	[discount_code] [varchar](20) NOT NULL,
	[discount_name] [varchar](30) NOT NULL,
	[discount_type] [varchar](1) NOT NULL,
	[discount_amount] [numeric](8, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[discount_code_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pricing_categories]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pricing_categories](
	[pricing_category_code] [varchar](1) NOT NULL,
	[pricing_category_name] [varchar](20) NOT NULL,
	[pricing_start_date] [date] NOT NULL,
	[pricing_end_date] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[pricing_category_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[session_schedule]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[session_schedule](
	[schedule_id] [int] IDENTITY(1,1) NOT NULL,
	[time_slot_id] [int] NOT NULL,
	[session_id] [int] NOT NULL,
	[room] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[schedule_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[session_speakers]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[session_speakers](
	[session_id] [int] NOT NULL,
	[speaker_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[session_tags]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[session_tags](
	[session_id] [int] NOT NULL,
	[tag_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sessions]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sessions](
	[session_id] [int] IDENTITY(1,1) NOT NULL,
	[session_name] [varchar](80) NOT NULL,
	[session_description] [varchar](1024) NOT NULL,
	[session_length] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[session_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[speakers]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[speakers](
	[speaker_id] [int] IDENTITY(1,1) NOT NULL,
	[first_name] [varchar](30) NOT NULL,
	[last_name] [varchar](30) NOT NULL,
	[title] [varchar](40) NOT NULL,
	[company] [varchar](50) NOT NULL,
	[speaker_bio] [varchar](2000) NOT NULL,
	[speaker_photo] [varchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[speaker_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tags]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tags](
	[tag_id] [int] IDENTITY(1,1) NOT NULL,
	[description] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tag_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ticket_prices]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ticket_prices](
	[ticket_price_id] [int] IDENTITY(1,1) NOT NULL,
	[ticket_type_code] [varchar](1) NOT NULL,
	[pricing_category_code] [varchar](1) NOT NULL,
	[base_price] [numeric](8, 2) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ticket_price_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ticket_types]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ticket_types](
	[ticket_type_code] [varchar](1) NOT NULL,
	[ticket_type_name] [varchar](30) NOT NULL,
	[description] [varchar](100) NOT NULL,
	[includes_workshop] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ticket_type_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[time_slots]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[time_slots](
	[time_slot_id] [int] IDENTITY(1,1) NOT NULL,
	[time_slot_date] [date] NOT NULL,
	[start_time] [time](7) NOT NULL,
	[end_time] [time](7) NOT NULL,
	[is_keynote_time_slot] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[time_slot_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[workshop_registrations]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[workshop_registrations](
	[workshop_id] [int] NOT NULL,
	[attendee_ticket_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[workshop_speakers]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[workshop_speakers](
	[workshop_id] [int] NOT NULL,
	[speaker_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[workshops]    Script Date: 3/10/2020 10:47:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[workshops](
	[workshop_id] [int] IDENTITY(1,1) NOT NULL,
	[workshop_name] [varchar](60) NOT NULL,
	[description] [varchar](1024) NOT NULL,
	[requirements] [varchar](1024) NOT NULL,
	[room] [varchar](30) NOT NULL,
	[capacity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[workshop_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[time_slots] ADD  DEFAULT ((0)) FOR [is_keynote_time_slot]
GO
ALTER TABLE [dbo].[attendee_tickets]  WITH CHECK ADD  CONSTRAINT [FK_attendee_tickets_attendees] FOREIGN KEY([attendee_id])
REFERENCES [dbo].[attendees] ([attendee_id])
GO
ALTER TABLE [dbo].[attendee_tickets] CHECK CONSTRAINT [FK_attendee_tickets_attendees]
GO
ALTER TABLE [dbo].[attendee_tickets]  WITH CHECK ADD  CONSTRAINT [FK_attendee_tickets_discount_codes] FOREIGN KEY([discount_code_id])
REFERENCES [dbo].[discount_codes] ([discount_code_id])
GO
ALTER TABLE [dbo].[attendee_tickets] CHECK CONSTRAINT [FK_attendee_tickets_discount_codes]
GO
ALTER TABLE [dbo].[session_schedule]  WITH CHECK ADD  CONSTRAINT [FK_session_schedule_sessions] FOREIGN KEY([session_id])
REFERENCES [dbo].[sessions] ([session_id])
GO
ALTER TABLE [dbo].[session_schedule] CHECK CONSTRAINT [FK_session_schedule_sessions]
GO
ALTER TABLE [dbo].[session_schedule]  WITH CHECK ADD  CONSTRAINT [FK_session_schedule_time_slots] FOREIGN KEY([time_slot_id])
REFERENCES [dbo].[time_slots] ([time_slot_id])
GO
ALTER TABLE [dbo].[session_schedule] CHECK CONSTRAINT [FK_session_schedule_time_slots]
GO
ALTER TABLE [dbo].[session_speakers]  WITH CHECK ADD  CONSTRAINT [FK_session_speakers_sessions] FOREIGN KEY([session_id])
REFERENCES [dbo].[sessions] ([session_id])
GO
ALTER TABLE [dbo].[session_speakers] CHECK CONSTRAINT [FK_session_speakers_sessions]
GO
ALTER TABLE [dbo].[session_speakers]  WITH CHECK ADD  CONSTRAINT [FK_session_speakers_speakers] FOREIGN KEY([speaker_id])
REFERENCES [dbo].[speakers] ([speaker_id])
GO
ALTER TABLE [dbo].[session_speakers] CHECK CONSTRAINT [FK_session_speakers_speakers]
GO
ALTER TABLE [dbo].[session_tags]  WITH CHECK ADD  CONSTRAINT [FK_session_tags_sessions] FOREIGN KEY([session_id])
REFERENCES [dbo].[sessions] ([session_id])
GO
ALTER TABLE [dbo].[session_tags] CHECK CONSTRAINT [FK_session_tags_sessions]
GO
ALTER TABLE [dbo].[session_tags]  WITH CHECK ADD  CONSTRAINT [FK_session_tags_tags] FOREIGN KEY([tag_id])
REFERENCES [dbo].[tags] ([tag_id])
GO
ALTER TABLE [dbo].[session_tags] CHECK CONSTRAINT [FK_session_tags_tags]
GO
ALTER TABLE [dbo].[ticket_prices]  WITH CHECK ADD  CONSTRAINT [FK_ticket_prices_pricing_categories] FOREIGN KEY([pricing_category_code])
REFERENCES [dbo].[pricing_categories] ([pricing_category_code])
GO
ALTER TABLE [dbo].[ticket_prices] CHECK CONSTRAINT [FK_ticket_prices_pricing_categories]
GO
ALTER TABLE [dbo].[ticket_prices]  WITH CHECK ADD  CONSTRAINT [FK_ticket_prices_ticket_types] FOREIGN KEY([ticket_type_code])
REFERENCES [dbo].[ticket_types] ([ticket_type_code])
GO
ALTER TABLE [dbo].[ticket_prices] CHECK CONSTRAINT [FK_ticket_prices_ticket_types]
GO
ALTER TABLE [dbo].[workshop_registrations]  WITH CHECK ADD  CONSTRAINT [FK_workshop_registrations_attendee_tickets] FOREIGN KEY([attendee_ticket_id])
REFERENCES [dbo].[attendee_tickets] ([attendee_ticket_id])
GO
ALTER TABLE [dbo].[workshop_registrations] CHECK CONSTRAINT [FK_workshop_registrations_attendee_tickets]
GO
ALTER TABLE [dbo].[workshop_registrations]  WITH CHECK ADD  CONSTRAINT [FK_workshop_registrations_workshops] FOREIGN KEY([workshop_id])
REFERENCES [dbo].[workshops] ([workshop_id])
GO
ALTER TABLE [dbo].[workshop_registrations] CHECK CONSTRAINT [FK_workshop_registrations_workshops]
GO
ALTER TABLE [dbo].[workshop_speakers]  WITH CHECK ADD  CONSTRAINT [FK_workshop_speakers_speakers] FOREIGN KEY([speaker_id])
REFERENCES [dbo].[speakers] ([speaker_id])
GO
ALTER TABLE [dbo].[workshop_speakers] CHECK CONSTRAINT [FK_workshop_speakers_speakers]
GO
ALTER TABLE [dbo].[workshop_speakers]  WITH CHECK ADD  CONSTRAINT [FK_workshop_speakers_workshops] FOREIGN KEY([workshop_id])
REFERENCES [dbo].[workshops] ([workshop_id])
GO
ALTER TABLE [dbo].[workshop_speakers] CHECK CONSTRAINT [FK_workshop_speakers_workshops]
GO
USE [master]
GO
ALTER DATABASE [conference_app] SET  READ_WRITE 
GO
