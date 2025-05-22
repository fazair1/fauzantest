-- ----------------------------
-- Records of MstProductCategory
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstProductCategory] ON
    ;

    INSERT INTO [dbo].[MstProductCategory] ([IDCategory], [Nama]) VALUES (N'1', N'Food')
    ;

    INSERT INTO [dbo].[MstProductCategory] ([IDCategory], [Nama]) VALUES (N'2', N'Furniture')
    ;

    SET IDENTITY_INSERT [dbo].[MstProductCategory] OFF
    ;

-- ----------------------------
-- Records of MstProduct
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstProduct] ON
    ;

    INSERT INTO [dbo].[MstProduct] ([HargaProduct], [IDProduct], [NamaProduct], [IDProductCategory]) VALUES (N'5000', N'1', N'kursi', N'2')
    ;

    INSERT INTO [dbo].[MstProduct] ([HargaProduct], [IDProduct], [NamaProduct], [IDProductCategory]) VALUES (N'15000', N'2', N'meja', N'2')
    ;

    INSERT INTO [dbo].[MstProduct] ([HargaProduct], [IDProduct], [NamaProduct], [IDProductCategory]) VALUES (N'12000', N'3', N'apple', N'1')
    ;

    INSERT INTO [dbo].[MstProduct] ([HargaProduct], [IDProduct], [NamaProduct], [IDProductCategory]) VALUES (N'2000', N'4', N'pisang', N'1')
    ;

    SET IDENTITY_INSERT [dbo].[MstProduct] OFF
    ;