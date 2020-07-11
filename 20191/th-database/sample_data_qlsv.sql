USE [DBQLNV]

-- MONHOC

DELETE FROM [MONHOC];

INSERT INTO [dbo].[MONHOC]
           ([MSMH]
           ,[TENMH]
           ,[SOHT])
     VALUES
           (N'IT1110',N'Tin học đại cương',4),
           (N'IT3090',N'Cơ sở dữ liệu',3),
           (N'IT3080',N'Mạng máy tính',3),
           (N'ME2030',N'Cơ khí đại cương',3),
           (N'ME2100',N'Nhập môn cơ điện tử',2),
           (N'CH3220',N'Hoá hữu cơ',3);

-- MH_GV

DELETE FROM [MH_GV];

INSERT INTO [dbo].[MH_GV]
           ([MSMH]
           ,[TENGV])
     VALUES
           (N'IT1110',N'Nguyễn Duy Hiệp'),
           (N'IT1110',N'Trần Văn Đức'),
           (N'IT1110',N'Nguyễn Thanh Nga'),
           (N'IT3090',N'Nguyễn Thị Oanh'),
           (N'IT3090',N'Trần Văn Đức'),
           (N'IT3090',N'Nguyễn Duy Hiệp'),
           (N'IT3080',N'Trần Văn Đức'),
           (N'IT3080',N'Ngô Hồng Sơn'),
           (N'ME2030',N'Phạm Văn Hùng'),
           (N'ME2030',N'Trần Mạnh Hùng'),
           (N'ME2100',N'Phạm Văn Hùng'),
           (N'CH3220',N'Phan Ngọc Linh'),
		   (N'CH3220',N'Nguyễn Bích Hạnh'),
		   (N'CH3220',N'Nguyễn Thị Lan');

-- LOP
	   
DELETE FROM [LOP];

INSERT INTO [dbo].[LOP]
           ([MALOP]
           ,[TENLOP]
           ,[TENGVCN])
     VALUES
		(35945,N'Hoá vô cơ K59',N'Nguyễn Bích Hạnh'),
		(36077,N'CNPM K59',N'Nguyễn Duy Hiệp'),
		(95678,N'Cơ điện tử 1 K61',N'Trần Mạnh Hùng'),
		(33050,N'CNTT1 K60',N'Trần Văn Đức'),
		(44763,N'CNTT2 K60',N'Nguyễn Duy Hiệp'),
		(77543,N'Hoá hữu cơ K60',N'Phan Ngọc Linh');

-- SINHVIEN

DELETE FROM [SINHVIEN];

INSERT INTO [dbo].[SINHVIEN]
           ([MASV]
           ,[HOTEN]
           ,[NGAYSINH]
           ,[GIOITINH]
           ,[QUEQUAN]
           ,[NOICUTRU]
           ,[MALOP])
     VALUES
           (20131345,N'Nguyễn Văn Hạnh','1/6/1995',1,N'Lạng Sơn',N'B13 KTX Bách Khoa',35945),
           (20132234,N'Nguyễn Duy Linh','12/31/1995',1,N'Sơn La',N'B13 KTX Bách Khoa',36077),
           (20164678,N'Trần Mạnh Hùng','11/23/1997',1,N'Lạng Sơn',N'B13 KTX Bách Khoa',95678),
           (20152345,N'Trần Văn','6/5/1997',1,N'Hoà Bình',N'15 Hồ Xuân Hương',33050),
           (20153423,N'Nguyễn Hiệp Hoà','12/8/1997',1,N'An Giang',N'B13 KTX Bách Khoa',44763),
           (20150187,N'Phan Linh','12/8/1997',1,N'Hà Nội',N'55 Hàng Bài',77543),
           (20132222,N'Trần Thị Linh','2/2/1995',0,N'Nam Định',N'B14 KTX Bách Khoa',77543),
           (20151990,N'Nguyễn Thuỳ Linh','9/11/1995',0,N'Hà Nội',N'34 Trần Phú',77543),
           (20152467,N'Lê Văn Xuân','4/4/1995',1,N'Lạng Sơn',N'B13 KTX Bách Khoa',33050);

-- DANGKY
			   
DELETE FROM [DANGKY];

INSERT INTO [dbo].[DANGKY]
           ([MSSV]
           ,[MSMH]
           ,[KYHOC]
           ,[DIEMQT]
           ,[DIEMCK])
     VALUES
           (20131345,N'CH3220',1,8,7),
           (20132234,N'IT3080',2,8.5,9),
           (20164678,N'ME2100',1,7,9),
           (20152345,N'IT3080',3,6.5,8),
           (20153423,N'IT3090',2,4,5),
           (20150187,N'CH3220',1,2,0),
           (20132222,N'IT1110',4,3,7),
           (20151990,N'IT1110',2,4,8),
           (20152467,N'ME2100',1,7,9.5),
           (20152345,N'IT1110',1,8.5,6.5),
           (20153423,N'IT3080',1,9.5,7.5),
           (20150187,N'ME2100',1,6.5,9.5),
           (20132222,N'IT3080',2,9.5,10),
           (20151990,N'IT3090',2,4.5,9),
           (20152467,N'IT1110',2,6.5,8);


