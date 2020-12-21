-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" ("id", "active", "address", "email", "name", "password", "phone", "role", "mobile_phone", "extension", "doc_type", "doc_number", "create_time", "update_time" ) VALUES (2147483642, 't', 'Calle 25 # 12 - 72', 'manager1@email.com', 'MANAGER I', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', '987654321', 'ROLE_MANAGER', '3854444', '2400', '2', 103543534543, '2018-03-09 23:03:26', '2018-03-10 00:15:27');

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (5, 'ANTIOQUIA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (8,'ATLÁNTICO', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (11,'BOGOTÁ, D.C.', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (13,'BOLÍVAR', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (15,'BOYACÁ', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (17,'CALDAS', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (18,'CAQUETÁ', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (19,'CAUCA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (20,'CESAR', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (23,'CÓRDOBA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (25,'CUNDINAMARCA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (27,'CHOCÓ', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (41,'HUILA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (44,'LA GUAJIRA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (47,'MAGDALENA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (50,'META', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (52,'NARIÑO', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (54,'NORTE DE SANTANDER', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (63,'QUINDIO', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (66,'RISARALDA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (68,'SANTANDER', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (70,'SUCRE', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (73,'TOLIMA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (76,'VALLE DEL CAUCA, 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (81,'ARAUCA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (85,'CASANARE', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (86,'PUTUMAYO', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (88,'ARCHIPIÉLAGO DE SAN ANDRÉS, PROVIDENCIA Y SANTA CATALINA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (91,'AMAZONAS', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (94,'GUAINÍA', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (95,'GUAVIARE', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (97,'VAUPÉS', 't');
INSERT INTO "public"."department" ("department_id", "department_name", "enabled", "create_time", "update_time") VALUES (99,'VICHADA', 't');

-- ----------------------------
-- Records of cities
-- ----------------------------
INSERT INTO "public"."city" ("city_id", "city_name", "enabled", "department_id", "create_time", "update_time") VALUES (0, 'BOGOTA', 't', 2, '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."city" ("city_id", "city_name", "enabled", "department_id", "create_time", "update_time") VALUES (1, 'MEDELLIN', 't', 0, '2018-03-10 00:15:02', '2018-03-10 00:15:21');
INSERT INTO "public"."city" ("city_id", "city_name", "enabled", "department_id", "create_time", "update_time") VALUES (2, 'CALI', 't', 3, '2018-03-10 01:01:09', '2018-03-10 01:01:09');
INSERT INTO "public"."city" ("city_id", "city_name", "enabled", "department_id", "create_time", "update_time") VALUES (3, 'BARRANQUILLA', 'f', 1, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

-- ----------------------------
-- Records of project_category
-- ----------------------------
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (0, 'A - Material Vivo o Animal y Vegetal', '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (1, 'B - Materias primas B', '2018-03-10 00:15:02', '2018-03-10 00:15:21');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (2, 'C - Maquinaria, herramientas, equipo industrial y vehículos', '2018-03-10 01:01:09', '2018-03-10 01:01:09');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (3, 'D - Componentes y suministros', '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (4, 'E - Productos de uso final', '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (5, 'F - Servicios', '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_category" ("category_id", "category_name", "create_time", "update_time") VALUES (6, 'G - Terrenos, edificios, estructuras y vías', '2018-03-10 00:26:05', '2018-03-10 00:26:05');

-- ----------------------------
-- Records of project_segment
-- ----------------------------
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (10, '10 - Material Vivo Vegetal y Animal, Accesorios y Suministros', 0, '2018-03-09 23:03:26', '2018-03-10 00:15:27');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (11, '11 - Material Mineral, Textil y  Vegetal y Animal No Comestible', 1, '2018-03-10 00:15:02', '2018-03-10 00:15:21');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (12, '12 - Material Químico incluyendo Bioquímicos y Materiales de Gas', 1, '2018-03-10 01:01:09', '2018-03-10 01:01:09');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (13, '13 - Materiales de Resina, Colofonia, Caucho, Espuma, Película y Elastómericos', 1, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (14, '14 - Materiales y Productos de Papel', 1, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (15, '15 - Materiales Combustibles, Aditivos para Combustibles, Lubricantes y Anticorrosivos', 1, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (20, '20 - Maquinaria y Accesorios de Minería y Perforación de Pozos', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (21, '21 - Maquinaria y Accesorios para Agricultura, Pesca, Silvicultura y Fauna', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (22, '22 - Maquinaria y Accesorios para Construcción y Edificación', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (23, '23 - Maquinaria y Accesorios para Manufactura y Procesamiento Industrial', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (24, '24 - Maquinaria, Accesorios y Suministros para Manejo, Acondicionamiento y Almacenamiento de Materiales', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (25, '25 - Vehículos Comerciales, Militares y Particulares, Accesorios y Componentes', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (26, '26 - Maquinaria y Accesorios para Generación y Distribución de Energía', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (27, '27 - Herramientas y Maquinaria General', 2, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (30, '30 - Componentes y Suministros para Estructuras, Edificación, Construcción y Obras Civiles', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (31, '31 - Componentes y Suministros de Manufactura', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (32, '32 - Componentes y Suministros Electrónicos', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (39, '39 - Componentes, Accesorios y Suministros de Sistemas Eléctricos e Iluminación', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (40, '40 - Componentes y Equipos para Distribución y Sistemas de Acondicionamiento', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (41, '41 - Equipos y Suministros de Laboratorio, de Medición, de Observación y de Pruebas', 3, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (42, '42 - Equipo Médico, Accesorios y Suministros', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (43, '43 - Difusión de Tecnologías de Información y Telecomunicaciones', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (44, '44 - Equipos de Oficina, Accesorios y Suministros', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (45, '45 - Equipos y Suministros para Impresión, Fotografia y Audiovisuales', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (46, '46 - Equipos y Suministros de Defensa, Orden Publico, Proteccion, Vigilancia y Seguridad', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (47, '47 - Equipos de Limpieza y Suministros', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (48, '48 - Maquinaria, Equipo y Suministros para la Industria de Servicios', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (49, '49 - Equipos, Suministros y Accesorios para Deportes y Recreación', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (50, '50 - Alimentos, Bebidas y Tabaco', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (51, '51 - Medicamentos y Productos Farmacéuticos', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (52, '52 - Artículos Domésticos, Suministros y Productos Electrónicos de Consumo ', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (53, '53 - Ropa, Maletas y Productos de Aseo Personal', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (54, '54 - Productos para Relojería, Joyería y Piedras Preciosas', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (55, '55 - Publicaciones Impresas, Publicaciones Electrónicas y Accesorios', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (56, '56 - Muebles, Mobiliario y Decoración', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (60, '60 - Instrumentos Musicales, Juegos, Juguetes, Artes, Artesanías y Equipo educativo, Materiales, Accesorios y Suministros', 4, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (70, '70 - Servicios de Contratacion Agrícola, Pesquera, Forestal y de Fauna', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (71, '71 - Servicios de Minería, Petróleo y Gas', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (72, '72 - Servicios de Edificación, Construcción de Instalaciones y Mantenimiento', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (73, '73 - Servicios de Producción Industrial y Manufactura', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (76, '76 - Servicios de Limpieza, Descontaminación y Tratamiento de Residuos', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (77, '77 - Servicios Medioambientales', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (78, '78 - Servicios de Transporte, Almacenaje y Correo', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (80, '80 - Servicios de Gestión, Servicios Profesionales de Empresa y Servicios Administrativos', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (81, '81 - Servicios Basados en Ingeniería, Investigación y Tecnología', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (82, '82 - Servicios Editoriales, de Diseño, de Artes Graficas y Bellas Artes', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (83, '83 - Servicios Públicos y Servicios Relacionados con el Sector Público', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (84, '84 - Servicios Financieros y de Seguros', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (85, '85 - Servicios de Salud', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (90, '90 - Servicios de Viajes, Alimentación, Alojamiento y Entretenimiento', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (91, '91 - Servicios Personales y Domésticos', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (92, '92 - Servicios de Defensa Nacional, Orden Publico, Seguridad y Vigilancia', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (93, '93 - Servicios Políticos y de Asuntos Cívicos', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');
INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (94, '94 - Organizaciones y Clubes', 5, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

INSERT INTO "public"."project_segment" ("segment_id", "segment_name", "category_id", "create_time", "update_time") VALUES (95, '95 - Terrenos, Edificios, Estructuras y Vías', 6, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

-- ----------------------------
-- Records of project_product
-- ----------------------------
INSERT INTO "public"."project_product" ("product_id", "product_name", "segment_id", "create_time", "update_time") VALUES (1010, 'Animales vivos', 10, '2018-03-09 23:03:26', '2018-03-10 00:15:27');
INSERT INTO "public"."project_product" ("product_id", "product_name", "segment_id", "create_time", "update_time") VALUES (1011, 'Productos para animales domésticos', 10, '2018-03-10 00:15:02', '2018-03-10 00:15:21');
INSERT INTO "public"."project_product" ("product_id", "product_name", "segment_id", "create_time", "update_time") VALUES (1012, 'Recipientes y hábitat para animales', 10, '2018-03-10 01:01:09', '2018-03-10 01:01:09');
INSERT INTO "public"."project_product" ("product_id", "product_name", "segment_id", "create_time", "update_time") VALUES (1013, 'Productos de talabartería y arreo', 10, '2018-03-10 00:26:05', '2018-03-10 00:26:05');

