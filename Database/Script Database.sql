USE [master]
GO
/****** Object:  Database [EnglishTrainingCenter]    Script Date: 12/20/2018 10:42:33 AM ******/
CREATE DATABASE [EnglishTrainingCenter]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'EnglishTrainingCenter', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\EnglishTrainingCenter.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'EnglishTrainingCenter_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\EnglishTrainingCenter_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [EnglishTrainingCenter] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EnglishTrainingCenter].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EnglishTrainingCenter] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET ARITHABORT OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EnglishTrainingCenter] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EnglishTrainingCenter] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EnglishTrainingCenter] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EnglishTrainingCenter] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [EnglishTrainingCenter] SET  MULTI_USER 
GO
ALTER DATABASE [EnglishTrainingCenter] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EnglishTrainingCenter] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EnglishTrainingCenter] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EnglishTrainingCenter] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EnglishTrainingCenter] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [EnglishTrainingCenter] SET QUERY_STORE = OFF
GO
USE [EnglishTrainingCenter]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [EnglishTrainingCenter]
GO
/****** Object:  Table [dbo].[CHUC_VU]    Script Date: 12/20/2018 10:42:33 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHUC_VU](
	[MaCV] [int] IDENTITY(10000,1) NOT NULL,
	[TenCV] [nvarchar](50) NULL,
	[Quyen] [int] NULL,
 CONSTRAINT [PK_CHUC_VU] PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOC_VIEN]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOC_VIEN](
	[MaHV] [int] IDENTITY(1000,1) NOT NULL,
	[TenHV] [nvarchar](255) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[SDT] [varchar](50) NULL,
	[NgaySinh] [datetime] NULL,
	[HocPhiDaDong] [money] NULL,
	[NgayThamGia] [datetime] NULL,
	[DiemDauVao] [float] NULL,
 CONSTRAINT [PK_HOC_VIEN] PRIMARY KEY CLUSTERED 
(
	[MaHV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHOA_HOC]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHOA_HOC](
	[MaKH] [int] IDENTITY(1000,1) NOT NULL,
	[TenKH] [nvarchar](255) NULL,
	[HocPhi] [money] NULL,
	[ThoiGianKD] [int] NULL,
	[DiemDauVao] [float] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_KHOA_HOC] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOP_HOC]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOP_HOC](
	[MaLH] [int] IDENTITY(1000,1) NOT NULL,
	[TenLH] [nvarchar](255) NULL,
	[SiSo] [int] NULL,
	[SoHVHienCo] [int] NULL,
	[ThoiGianHoc] [nvarchar](255) NULL,
	[NgayBatDau] [datetime] NULL,
	[NgayKetThuc] [datetime] NULL,
	[TrangThai] [bit] NULL,
	[Phong] [nvarchar](50) NULL,
	[MaKH] [int] NULL,
	[MaNV] [int] NULL,
 CONSTRAINT [PK_LOP_HOC] PRIMARY KEY CLUSTERED 
(
	[MaLH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHAN_VIEN]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHAN_VIEN](
	[MaNV] [int] IDENTITY(1000,1) NOT NULL,
	[TenNV] [nvarchar](255) NULL,
	[CMND] [varchar](50) NULL,
	[SDT] [varchar](50) NULL,
	[Luong] [money] NULL,
	[NgayVaoLam] [datetime] NULL,
	[TrangThai] [bit] NULL,
	[MaCV] [int] NULL,
	[MaTK] [int] NULL,
 CONSTRAINT [PK_NHAN_VIEN] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHI]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHI](
	[MaP] [int] NOT NULL,
	[TenP] [nvarchar](50) NULL,
	[SoTienThu] [money] NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PHI] PRIMARY KEY CLUSTERED 
(
	[MaP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAI_KHOAN]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAI_KHOAN](
	[MaTK] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](255) NULL,
 CONSTRAINT [PK_TAI_KHOAN] PRIMARY KEY CLUSTERED 
(
	[MaTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[THAM_GIA_KHOA_HOC]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[THAM_GIA_KHOA_HOC](
	[MaHV] [int] NOT NULL,
	[MaKH] [int] NOT NULL,
	[MaLH] [int] NOT NULL,
	[NgayBatDau] [datetime] NULL,
	[DiemTotNghiep] [float] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HOC_VIEN] ADD  CONSTRAINT [DF_HOC_VIEN_NgaySinh]  DEFAULT (getdate()) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[HOC_VIEN] ADD  CONSTRAINT [DF_HOC_VIEN_HocPhiDaDong]  DEFAULT ((0)) FOR [HocPhiDaDong]
GO
ALTER TABLE [dbo].[HOC_VIEN] ADD  CONSTRAINT [DF_HOC_VIEN_NgayThamGia]  DEFAULT (getdate()) FOR [NgayThamGia]
GO
ALTER TABLE [dbo].[HOC_VIEN] ADD  CONSTRAINT [DF_HOC_VIEN_DiemDauVao]  DEFAULT ((0.0)) FOR [DiemDauVao]
GO
ALTER TABLE [dbo].[KHOA_HOC] ADD  CONSTRAINT [DF_KHOA_HOC_HocPhi]  DEFAULT ((0)) FOR [HocPhi]
GO
ALTER TABLE [dbo].[KHOA_HOC] ADD  CONSTRAINT [DF_KHOA_HOC_ThoiGianKD]  DEFAULT ((0)) FOR [ThoiGianKD]
GO
ALTER TABLE [dbo].[KHOA_HOC] ADD  CONSTRAINT [DF_KHOA_HOC_DiemDauVao]  DEFAULT ((0.0)) FOR [DiemDauVao]
GO
ALTER TABLE [dbo].[KHOA_HOC] ADD  CONSTRAINT [DF_KHOA_HOC_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[LOP_HOC] ADD  CONSTRAINT [DF_LOP_HOC_SiSo]  DEFAULT ((0)) FOR [SiSo]
GO
ALTER TABLE [dbo].[LOP_HOC] ADD  CONSTRAINT [DF_LOP_HOC_SoHVHienCo]  DEFAULT ((0)) FOR [SoHVHienCo]
GO
ALTER TABLE [dbo].[LOP_HOC] ADD  CONSTRAINT [DF_LOP_HOC_NgayBatDau]  DEFAULT (getdate()) FOR [NgayBatDau]
GO
ALTER TABLE [dbo].[LOP_HOC] ADD  CONSTRAINT [DF_LOP_HOC_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NHAN_VIEN] ADD  CONSTRAINT [DF_NHAN_VIEN_Luong]  DEFAULT ((0)) FOR [Luong]
GO
ALTER TABLE [dbo].[NHAN_VIEN] ADD  CONSTRAINT [DF_NHAN_VIEN_NgayVaoLam]  DEFAULT (getdate()) FOR [NgayVaoLam]
GO
ALTER TABLE [dbo].[NHAN_VIEN] ADD  CONSTRAINT [DF_NHAN_VIEN_TrangThai]  DEFAULT ((1)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[PHI] ADD  CONSTRAINT [DF_PHI_SoTienThu]  DEFAULT ((0)) FOR [SoTienThu]
GO
ALTER TABLE [dbo].[THAM_GIA_KHOA_HOC] ADD  CONSTRAINT [DF_THAM_GIA_KHOA_HOC_NgayBatDau]  DEFAULT (getdate()) FOR [NgayBatDau]
GO
ALTER TABLE [dbo].[THAM_GIA_KHOA_HOC] ADD  CONSTRAINT [DF_THAM_GIA_KHOA_HOC_DiemTotNghiep]  DEFAULT ((0.0)) FOR [DiemTotNghiep]
GO
/****** Object:  StoredProcedure [dbo].[usp_add_trainee_to_class]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_add_trainee_to_class]
@courseId int,
@classId int,
@traineeId int
AS
BEGIN
	DECLARE @hasRecord int
	SELECT @hasRecord = COUNT(*) FROM THAM_GIA_KHOA_HOC WHERE MaLH = @classId AND MaKH = @courseId AND MaHV = @traineeId
	IF(@hasRecord = 0)
	BEGIN
		INSERT INTO THAM_GIA_KHOA_HOC (MaHV, MaKH, MaLH)
		VALUES (@traineeId, @courseId, @classId)
	END
END
GO
/****** Object:  StoredProcedure [dbo].[usp_check_credential]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_check_credential]
@username varchar(255),
@hash varchar(255)
AS
BEGIN
	SELECT MaTK FROM TAI_KHOAN WHERE Username = @username AND Password = @hash
END
GO
/****** Object:  StoredProcedure [dbo].[usp_check_user_exists]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_check_user_exists]
@username varchar(255)
AS
BEGIN
	SELECT * FROM TAI_KHOAN WHERE Username =  @username
END
GO
/****** Object:  StoredProcedure [dbo].[usp_deactive_course]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_deactive_course]
@id int
AS
BEGIN
	UPDATE KHOA_HOC SET TrangThai = 0 WHERE MaKH = @id
	UPDATE LOP_HOC SET TrangThai = 0 WHERE MaKH = @id
END
GO
/****** Object:  StoredProcedure [dbo].[usp_deactive_staff]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_deactive_staff]
@id int
AS
BEGIN
	UPDATE NHAN_VIEN
	SET TrangThai = 0, MaTK = -1
	WHERE MaNV = @id;

	DELETE FROM TAI_KHOAN WHERE MaTK = (SELECT MaTK FROM NHAN_VIEN WHERE MaNV = @id)

END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_class]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_class]
AS
BEGIN
	SELECT * FROM LOP_HOC
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_course]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_course]
AS
BEGIN
	SELECT * FROM KHOA_HOC
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_course_of_trainee]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_course_of_trainee]
@id int
AS
BEGIN
	SELECT t.MaLH, TenLH, t.MaKH, TenKH, DiemTotNghiep FROM LOP_HOC l INNER JOIN (THAM_GIA_KHOA_HOC t INNER JOIN KHOA_HOC k ON t.MaKH = k.MaKH) ON t.MaLH = l.MaLH
	WHERE t.MaHV = @id
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_staff]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_staff]
AS
BEGIN
	SELECT n.MaNV, n.TenNV, n.CMND, n.SDT, n.Luong, n.NgayVaoLam, c.MaCV, c.TenCV, t.Username, t.Password
	FROM CHUC_VU c INNER JOIN (NHAN_VIEN n INNER JOIN TAI_KHOAN t ON n.MaTK = t.MaTK) ON n.MaCV = c.MaCV
	WHERE n.TrangThai = 1
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_staff_available]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_staff_available]
AS
BEGIN
	SELECT MaNV, TenNV FROM NHAN_VIEN WHERE TrangThai = 1 AND MaCV = 10002
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_all_trainee]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_all_trainee]
AS
BEGIN
	SELECT * FROM HOC_VIEN
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_course_available]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_course_available]
AS
BEGIN
	SELECT MaKH, TenKH FROM KHOA_HOC WHERE TrangThai = 1 
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_list_class_in_course]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_list_class_in_course]
@id int
AS
BEGIN
	SELECT l.MaLH, TenLH, SiSo, SoHVHienCo, ThoiGianHoc, NgayBatDau, k.TenKH, k.HocPhi FROM LOP_HOC l INNER JOIN KHOA_HOC k ON l.MaKH = k.MaKH
	WHERE k.MaKH = @id AND SoHVHienCo < SiSo AND l.TrangThai = 1
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_list_trainee_in_class]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_list_trainee_in_class]
@classId int,
@courseId int
AS
BEGIN
	SELECT t.MaHV, h.TenHV, NgayBatDau, DiemTotNghiep FROM THAM_GIA_KHOA_HOC t INNER JOIN HOC_VIEN h ON t.MaHV = h.MaHV
	WHERE MaKH = @courseId AND MaLH = @classId
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_newest_trainee]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_newest_trainee]
AS
BEGIN
	SELECT TOP 1 MaHV, TenHV, DiaChi, NgaySinh, DiemDauVao FROM HOC_VIEN
	ORDER BY MaHV DESC
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_trainee_info]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_trainee_info]
@id int
AS
BEGIN
	SELECT TenHV, NgaySinh, DiaChi, DiemDauVao FROM HOC_VIEN WHERE MaHV = @id;
END
GO
/****** Object:  StoredProcedure [dbo].[usp_get_user_info]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_get_user_info]
@id int
AS
BEGIN
	SELECT n.MaNV, n.TenNV, n.CMND, n.SDT, n.Luong, n.NgayVaoLam, c.TenCV, c.Quyen
	FROM NHAN_VIEN n INNER JOIN CHUC_VU c ON n.MaCV = c.MaCV
	WHERE n.MaTK = @id
END
GO
/****** Object:  StoredProcedure [dbo].[usp_new_class]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_new_class]
@name nvarchar(255),
@capa int,
@time nvarchar(255),
@started datetime,
@ended datetime,
@room nvarchar(255),
@courseId int,
@staffId int
AS
BEGIN
	INSERT INTO LOP_HOC (TenLH, SiSo, ThoiGianHoc, NgayBatDau, NgayKetThuc, Phong, MaKH, MaNV)
	VALUES (@name, @capa, @time, @started, @ended,@room, @courseId,  @staffId)
END
GO
/****** Object:  StoredProcedure [dbo].[usp_new_course]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_new_course]
@name nvarchar(255),
@fee money,
@duration int,
@benchMark float
AS
BEGIN
	INSERT INTO KHOA_HOC (TenKH, HocPhi, ThoiGianKD, DiemDauVao) VALUES (@name, @fee, @duration, @benchMark)  
END
GO
/****** Object:  StoredProcedure [dbo].[usp_new_staff]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_new_staff]
@name nvarchar(255),
@idCard varchar(255),
@phone varchar(255),
@idRole int,
@salary money,
@username varchar(255),
@password varchar(255)
AS
BEGIN
	
	 INSERT INTO TAI_KHOAN
	 VALUES (@username, @password)

	 DECLARE @idAcc int
	 SELECT @idAcc = MaTK FROM TAI_KHOAN WHERE Username = @username

	 INSERT INTO NHAN_VIEN
	 VALUES (@name, @idCard, @phone, @salary, getdate(), 1, @idRole, @idAcc);
END
GO
/****** Object:  StoredProcedure [dbo].[usp_new_trainee]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_new_trainee]
@name nvarchar(255),
@addr nvarchar(255),
@phoneNum nvarchar(15),
@birth datetime,
@mark float
AS
BEGIN
	INSERT INTO HOC_VIEN (TenHV, DiaChi, SDT, NgaySinh, DiemDauVao)
	VALUES (@name, @addr, @phoneNum, @birth, @mark)
END
GO
/****** Object:  StoredProcedure [dbo].[usp_update_course]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_update_course]
@id int,
@name nvarchar(255),
@fee money,
@duration int,
@benchMark float
AS
BEGIN
	UPDATE KHOA_HOC SET TenKH = @name, HocPhi = @fee, ThoiGianKD = @duration, DiemDauVao = @benchMark
	WHERE MaKH = @id
END
GO
/****** Object:  StoredProcedure [dbo].[usp_update_staff]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_update_staff]
@id int,
@idcard varchar(255),
@phoneNum varchar(255),
@idRole int,
@salary money
AS
BEGIN
	UPDATE NHAN_VIEN
	SET CMND = @idcard, SDT = @phoneNum, MaCV = @idRole, Luong = @salary
	WHERE MaNV = @id
END
GO
/****** Object:  StoredProcedure [dbo].[usp_update_trainee]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_update_trainee]
@id int,
@name nvarchar(255),
@phone varchar(20),
@addr nvarchar(255),
@birth datetime,
@fee money,
@testMark float
AS
BEGIN
	UPDATE HOC_VIEN
	SET TenHV = @name, SDT = @phone, DiaChi = @addr, NgaySinh = @birth, HocPhiDaDong = @fee, DiemDauVao = @testMark
	WHERE MaHV = @id;
END
GO
/****** Object:  StoredProcedure [dbo].[usp_update_trainee_mark]    Script Date: 12/20/2018 10:42:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[usp_update_trainee_mark]
@classId int,
@courseId int,
@traineeId int,
@mark float
AS
BEGIN
	UPDATE THAM_GIA_KHOA_HOC SET DiemTotNghiep = @mark
	WHERE MaLH = @classId AND MaKH = @courseId AND MaHV = @traineeId
END
GO
USE [master]
GO
ALTER DATABASE [EnglishTrainingCenter] SET  READ_WRITE 
GO
