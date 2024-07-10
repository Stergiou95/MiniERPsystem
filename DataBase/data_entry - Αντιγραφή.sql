INSERT INTO QC_REPORTS (result) VALUES
('A CLASS'),('B CLASS'),('C CLASS'),('D CLASS');




INSERT INTO CATEGORIES (categoryName) VALUES 
('Cement'),
('Plastic'),
('Bricks'),
('Blocks'),
('Steel'),
('Iron'),
('Wood'),
('Gypsum boards'),
('Insulation');


INSERT INTO RAW_MATERIALS (raw_material_name, raw_material_description) VALUES 
('Silica Sand', 'High-purity quartz sand used in the production of glass and silicon carbide'),
('Limestone', 'Calcium-rich sedimentary rock used as a primary ingredient in cement production'),
('Clay', 'Mineral-rich soil material containing alumina and silica, used as a binder in cement'),
('Iron Ore', 'Natural rock containing iron minerals, used as a source of iron in cement kilns'),
('Alumina', 'Chemical compound used as a source of aluminum in cement manufacturing'),
('Gypsum', 'Soft sulfate mineral added to cement to control setting time and improve strength'),
('Fly Ash', 'Fine powder residue left after the combustion of coal, used as a supplementary cementitious material'),
('Slag', 'By-product of steel production, used as a cementitious material and aggregate in concrete'),
('Calcium Carbonate', 'Chemical compound used as a filler and extender in cementitious materials'),
('Sulfuric Acid', 'Strong mineral acid used in the production of synthetic gypsum for cement manufacturing'),
('Sodium Silicate', 'Chemical compound used as a cement admixture to improve workability and durability'),
('Potassium Hydroxide', 'Strong base used in the production of alkali-activated cementitious materials'),
('Magnesium Oxide', 'Chemical compound used as a stabilizer in cementitious materials and as a refractory material'),
('Calcium Chloride', 'Hygroscopic salt used as an accelerator in cement hydration reactions'),
('Hydrochloric Acid', 'Strong mineral acid used in the production of chloride-based cement additives');

INSERT INTO LOCATIONS (location_name)
VALUES 
('Athens'), ('Thessaloniki'), ('Patras'), ('Heraklion'), 
('Larisa'), 
('Volos'), ('Ioannina'), ('Kavala'), ('Kalamata'), ('Alexandroupoli'),
('Chania'), ('Rhodes'), ('Serres'), ('Trikala'), ('Agrinio'),
('Xanthi'), ('Chalkida'), ('Katerini'), ('Veria'), ('Giannitsa'),
('Drama'), ('Lamia'), ('Kozani'), ('Kastoria'), ('Rethymno'),
('Sparti'), ('Pyrgos'), ('Korinthos'), ('Naoussa'), ('Edessa');


INSERT INTO WAREHOUSES_OF_RAW_MATERIALS (locationID, capacity) VALUES 
(1, 2000.00),  
(1, 2000.00),  
(1, 1500.00),   
(2, 1200.00),  
(2, 1900.00),   
(2, 1500.00),  
(3, 1750.00),   
(3, 1850.00),   
(3, 2600.00),  
(4, 3700.00),   
(4, 1000.00);   


INSERT INTO CUSTOMERS (company_name, email, locationID) VALUES
('ABC Construction', 'abc@example.com', 2),    
('XYZ Builders', 'xyz@example.com', 1),        
('BuildItUp Ltd.', 'buildit@example.com', 3), 
('CementCo', 'cementco@example.com', 4),      
('Elite Builders', 'elite@example.com', 1),    
('Concrete Creations', 'concrete@example.com', 2), 
('Solid Structures', 'solid@example.com', 3),      
('StoneCraft', 'stonecraft@example.com', 4),  
('MegaConstruct', 'mega@example.com', 2),        
('Everlast Builders', 'everlast@example.com', 1),  
('Stronghold Construction', 'stronghold@example.com', 3),
('Builders R Us', 'buildersrus@example.com', 4),      
('Titan Contractors', 'titan@example.com', 1),         
('Golden Hammer Builders', 'goldenhammer@example.com', 2), 
('Athenian Builders', 'athenian@example.com', 1),          
('BlueSky Builders', 'bluesky@example.com', 4),             
('Mosaic Construction', 'mosaic@example.com', 1),           
('Solid Foundations', 'foundations@example.com', 2),        
('Creative Concrete', 'creativeconcrete@example.com', 3),  
('Diamond Builders', 'diamond@example.com', 4),            
('Peak Construction', 'peak@example.com', 1),              
('Sturdy Structures', 'sturdy@example.com', 2),            
('Pegasus Builders', 'pegasus@example.com', 3),            
('Evergreen Construction', 'evergreen@example.com', 4),    
('Sunrise Builders', 'sunrise@example.com', 1),            
('Azure Construction', 'azure@example.com', 2),            
('Royal Builders', 'royal@example.com', 3),                 
('Harbor Construction', 'harbor@example.com', 4),          
('A1 Construction', 'a1@example.com', 5),
('Builders Unlimited', 'buildersunlimited@example.com', 6),
('Mediterranean Builders', 'mediterranean@example.com', 7),
('Concrete Kings', 'concretekings@example.com', 8),
('Hellenic Builders', 'hellenic@example.com', 9),
('Peloponnesian Contractors', 'peloponnesian@example.com', 10),
('Northern Builders', 'northern@example.com', 11),
('Crete Construction', 'crete@example.com', 12),
('Rhodes Builders', 'rhodes@example.com', 13),
('Serres Construction', 'serres@example.com', 14),
('Thessaly Builders', 'thessaly@example.com', 15),
('Western Builders', 'western@example.com', 16),
('Xanthi Construction', 'xanthi@example.com', 17),
('Central Construction', 'central@example.com', 18),
('Olympus Builders', 'olympus@example.com', 19),
('Northern Greece Contractors', 'northerngreece@example.com', 20),
('Pella Builders', 'pella@example.com', 21),
('Drama Construction', 'drama@example.com', 22),
('Lamia Builders', 'lamia@example.com', 23),
('West Macedonia Construction', 'westmacedonia@example.com', 24),
('Kastoria Builders', 'kastoria@example.com', 25),
('Cretan Construction', 'cretan@example.com', 26),
('Sparta Builders', 'sparta@example.com', 27),
('Pyrgos Construction', 'pyrgos@example.com', 28),
('Corinthian Contractors', 'corinthian@example.com', 29),
('Naousa Builders', 'naousa@example.com', 30),
('Edessa Construction', 'edessa@example.com', 30);


INSERT INTO SHIFTS (start_time, end_time)
VALUES
('08:00:00', '16:00:00'),
('16:00:00', '00:00:00'),
('00:00:00', '08:00:00');


INSERT INTO SUPPLIERS (company_name, email, locationID)
VALUES
('ABC Chemicals', 'abc@example.com', 1),
('XYZ Materials', 'xyz@example.com', 2),
('Alpha Industries', 'alpha@example.com', 3),
('Beta Corporation', 'beta@example.com', 1),
('Gamma Ltd', 'gamma@example.com', 2),
('Delta Co.', 'delta@example.com', 3),
('Sigma Suppliers', 'sigma@example.com', 1),
('Omega Enterprises', 'omega@example.com', 2),
('Nu Manufacturers', 'nu@example.com', 3),
('Zeta Materials', 'zeta@example.com', 1);



INSERT INTO COMPLIANCES (compliance_name, cost)
VALUES
('ISO 9001', 500.00),
('ISO 14001', 750.00),
('OSHA Compliance', 1000.00),
('Environmental Protection Act Compliance', 1250.00),
('Health and Safety Executive Compliance', 800.00),
('Quality Management System Compliance', 600.00),
('FDA Compliance', 1500.00),
('CE Marking Compliance', 900.00),
('FCC Compliance', 1100.00),
('UL Compliance', 850.00);


INSERT INTO STATUSES (status_name) VALUES
('Ordered'), ('In Production'), ('Ready to Deliver'), ('In Delivery'), ('Completed'), ('Cancelled');


INSERT INTO ROLES (role)
VALUES
('Production Manager'),
('Production Supervisor'),
('Production Worker'),
('Quality Control Inspector');


INSERT INTO PARTNERS (Company_Name, email, locationID)
VALUES
('Transport Solutions Ltd', 'info@transportsolutions.com', 1),
('Express Logistics', 'contact@expresslogistics.com', 2),
('Freight Forwarders Inc', 'info@freightforwarders.com', 3),
('Swift Transport Services', 'info@swifttransport.com', 4),
('Global Shipping Co', 'contact@globalshipping.com', 5);



INSERT INTO PRODUCTS (name, price, construction_time, length, weight, thickness, categoryID)
VALUES
('Cement Bag', 10.50, 1, 50, 25.5, 10.2, 1),
('Concrete Block', 5.75, 2, 30, 20.3, 15.8, 1),
('Brick', 0.50, 1, 22, 10.2, 5.5, 1),
('Gravel', 20.25, 1, 100, 150.8, 0.0, 2),
('Sand', 15.80, 1, 120, 130.5, 0.0, 2),
('Cement Mixer', 200.00, 5, 0, 350.0, 200.0, 3),
('Concrete Pump', 500.00, 8, 0, 450.0, 300.0, 3),
('Concrete Truck', 300.00, 6, 0, 500.0, 250.0, 3),
('Rebar', 2.50, 1, 600, 400.0, 0.0, 4),
('Steel Beam', 150.00, 3, 800, 600.0, 50.0, 4),
('Wood Plank', 3.75, 1, 200, 100.0, 2.5, 5),
('Plywood Sheet', 12.50, 2, 240, 150.0, 1.0, 5),
('Scaffolding', 50.00, 3, 0, 300.0, 150.0, 6),
('Construction Adhesive', 8.00, 1, 0, 2.5, 1.5, 7),
('Concrete Sealer', 15.00, 1, 0, 5.0, 3.0, 7);


INSERT INTO MEMBERS (firstname, lastname, roleID)
VALUES
('John', 'Doe', 1),  -- Production Manager
('Jane', 'Smith', 1), -- Production Manager
('Mike', 'Johnson', 1), -- Production Manager
('Emily', 'Williams', 1), -- Production Manager
('Alex', 'Brown', 2),  -- Production Supervisor
('Samantha', 'Jones', 2), -- Production Supervisor
('David', 'Clark', 2), -- Production Supervisor
('Rachel', 'Taylor', 2), -- Production Supervisor
('Chris', 'Martinez', 3), -- Production Worker
('Lisa', 'Garcia', 3), -- Production Worker
('Kevin', 'Rodriguez', 3), -- Production Worker
('Sarah', 'Lopez', 3), -- Production Worker
('Daniel', 'Hernandez', 4), -- Quality Control Inspector
('Michelle', 'Martinez', 4), -- Quality Control Inspector
('Andrew', 'Gonzalez', 4), -- Quality Control Inspector
('Maria', 'Perez', 4); -- Quality Control Inspector


INSERT INTO RAW_MATERIALS_WAREHOUSE_RAW_MATERIALS (stocked_quantity, rawMatID, warehouseID)
VALUES
(100, 1, 1),  -- Silica Sand
(150, 2, 1),  -- Limestone
(200, 3, 2),  -- Clay
(120, 4, 2),  -- Iron Ore
(80, 5, 3),   -- Alumina (2)
(90, 6, 3),   -- Gypsum
(110, 7, 1),  -- Fly Ash
(70, 8, 1),   -- Slag
(100, 9, 2),  -- Calcium Carbonate
(130, 10, 2), -- Sulfuric Acid
(160, 11, 3), -- Sodium Silicate
(180, 12, 3), -- Potassium Hydroxide
(100, 13, 5), -- Magnesium Oxide
(140, 14, 1), -- Calcium Chloride
(120, 15, 2), -- Hydrochloric Acid
(190, 1, 2),   -- Silica Sand 
(800, 1, 4),   -- Silica Sand 
(110, 2, 7),  -- Limestone 
(85, 3, 3),   -- Clay 
(95, 4, 1),   -- Iron Ore 
(105, 5, 1),  -- Alumina 
(115, 6, 2),  -- Gypsum 
(125, 7, 2),  -- Fly Ash 
(80, 8, 3),   -- Slag 
(70, 9, 11),   -- Calcium Carbonate 
(70, 9, 7),   -- Calcium Carbonate 
(70, 9, 6),   -- Calcium Carbonate 
(150, 10, 1), -- Sulfuric Acid 
(135, 11, 5), -- Sodium Silicate 
(145, 12, 2), -- Potassium Hydroxide 
(125, 13, 9), -- Magnesium Oxide ()
(125, 13, 8), -- Magnesium Oxide ()
(95, 14, 3);  -- Calcium Chl





INSERT INTO RAW_MATERIALS_SUPPLIERS (CostPerUnit, rawMatID, supplier_ID)
VALUES
(48.00, 1, 4),
(52.00, 1, 5),
(48.00, 2, 4),
(52.00, 2, 5),
(47.00, 1, 3),
(51.00, 2, 3),
(62.00, 3, 4),
(58.00, 3, 5),
(75.00, 4, 4),
(80.00, 4, 5),
(50.00, 5, 4),
(60.00, 5, 5),
(70.00, 6, 4),
(60.00, 6, 5),
(38.00, 7, 4),
(42.00, 7, 5),
(32.00, 8, 4),
(38.00, 8, 5),
(27.00, 9, 4),
(33.00, 9, 5),
(85.00, 10, 4),
(75.00, 10, 5),
(72.00, 11, 4),
(78.00, 11, 5),
(50.00, 12, 4),
(58.00, 12, 5),
(68.00, 13, 4),
(78.00, 13, 5),
(55.00, 14, 4),
(65.00, 14, 5),
(52.00, 8, 7),
(36.00, 8, 8),
(22.00, 9, 9),
(43.00, 9, 10),(47.00, 9, 1),
(115.00, 10, 7),
(75.00, 10, 6),
(22.00, 11, 8),
(86.00, 11, 6),
(55.00, 12, 8),
(58.00, 12, 6),
(68.00, 13, 8),
(78.00, 13, 7),
(55.00, 14, 10),
(65.00, 14, 9),
(75.00, 10, 1),
(23.00, 11, 1),
(85.00, 11, 2),
(65.00, 12, 2),
(53.00, 12, 3),
(61.00, 13, 2),
(78.00, 13, 1),
(53.00, 14, 3),
(65.00, 14, 2);


INSERT INTO PRODUCTS_RAW_MATERIALS (quantity_per_product, productID, rawMatID)
VALUES
(10, 1, 1),
(5, 1, 2),
(8, 1, 3),

(12, 2, 1),
(6, 2, 2),
(9, 2, 3),

(15, 3, 1),
(7, 3, 8),
(11, 3, 3),

(18, 4, 4),
(4, 4, 5),

(20, 5, 5),

(8, 6, 1),
(10, 6, 6),
(5, 6, 12),

(15, 7, 6),
(12, 7, 7),
(7, 7, 12),

(10, 8, 6),
(15, 8, 7),
(8, 8, 12),

(15, 9, 9),

(12, 10, 9),
(5, 10, 8),

(8, 11, 10),

(10, 12, 12),

(20, 13, 11),
(15, 13, 13),

(10, 14, 6),
(15, 14, 13),

(15, 15, 13),
(30, 15, 1),
(10, 15, 10);

select * from RAW_MATERIALS;
select * from PRODUCTS



INSERT INTO MEMBERS_SHIFT (shiftID, memberID)
VALUES
(1, 1),   -- Production Manager - Shift 1
(2, 2),   -- Production Manager - Shift 2
(3, 3),   -- Production Manager - Shift 3

(1, 5),   -- Production Supervisor - Shift 1
(2, 6),   -- Production Supervisor - Shift 2
(3, 7),   -- Production Supervisor - Shift 3

(1, 9),   -- Production Worker 1 - Shift 1
(2, 10),   -- Production Worker 1 - Shift 2
(3, 11),   -- Production Worker 1 - Shift 3

(1, 13),   -- Quality Control Inspector - Shift 1
(2, 15),   -- Quality Control Inspector - Shift 2
(3, 16);   -- Quality Control Inspector - Shift 3



INSERT INTO COMPLIANCE_PRODUCTS (expire_date, compliance_id, productID)
VALUES
('2024-12-31', 1, 1),
('2025-01-31', 2, 1),
('2025-02-28', 3, 1),
('2024-11-30', 4, 1),
('2024-12-31', 2, 2),
('2025-01-31', 3, 2),
('2025-02-28', 4, 2),
('2024-11-30', 1, 3),
('2024-12-31', 3, 3),
('2025-01-31', 4, 3),
('2025-02-28', 1, 4),
('2024-11-30', 2, 4),
('2024-12-31', 4, 4),
('2025-01-31', 1, 5),
('2025-02-28', 2, 5),
('2024-11-30', 3, 5),
('2024-12-31', 1, 6),
('2025-01-31', 2, 6),
('2025-02-28', 3, 6),
('2024-11-30', 4, 6),
('2024-12-31', 1, 7),
('2025-01-31', 2, 7),
('2025-02-28', 3, 7),
('2024-11-30', 4, 7),
('2025-01-31', 1, 8),
('2025-02-28', 2, 8),
('2024-11-30', 3, 8),
('2024-12-31', 1, 9),
('2025-01-31', 2, 9),
('2025-02-28', 3, 9),
('2024-11-30', 4, 9),
('2024-12-31', 1, 10),
('2025-01-31', 2, 10),
('2025-02-28', 3, 10),
('2024-11-30', 4, 10),
('2024-12-31', 1, 11),
('2025-01-31', 2, 11),
('2025-02-28', 3, 11),
('2024-11-30', 4, 11),
('2025-01-31', 1, 12),
('2025-02-28', 2, 12),
('2024-11-30', 3, 12),
('2024-12-31', 1, 13),
('2025-01-31', 2, 13),
('2025-02-28', 3, 13),
('2024-11-30', 4, 13),
('2024-12-31', 1, 14),
('2025-01-31', 2, 14),
('2025-02-28', 3, 14),
('2024-11-30', 4, 14),
('2024-12-31', 1, 15),
('2025-01-31', 2, 15),
('2025-02-28', 3, 15),
('2024-11-30', 4, 15);


-- Insert 20 orders into the ORDERS table with a single INSERT statement
INSERT INTO ORDERS (custID, partnerID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5),
(11, 1),
(12, 2),
(13, 3),
(14, 4),
(15, 5),
(16, 1),
(17, 2),
(18, 3),
(19, 4),
(20, 5),(21, 1),
(22, 2),
(23, 3),
(24, 4),
(25, 5),
(26, 1),
(27, 2),
(28, 3),
(29, 4),
(30, 5),
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5),
(11, 1),
(12, 2),
(13, 3),
(14, 4),
(15, 5),
(16, 1),
(17, 2),
(18, 3),
(19, 4),
(20, 5),
(21, 1),
(22, 2),
(23, 3),
(24, 4),
(25, 5),
(26, 1),
(27, 2),
(28, 3),
(29, 4),
(30, 5),
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5);



INSERT INTO products_orders (orderID, productID, units) VALUES 
(1, 1, 10),
(1, 2, 15),
(2, 3, 5),
(2, 4, 20),
(3, 5, 12),
(3, 1, 7),
(4, 2, 25),
(4, 3, 10),
(5, 4, 18),
(5, 5, 30),
(6, 1, 20),
(6, 2, 9),
(7, 3, 8),(7, 4, 17),(8, 5, 14),(8, 1, 6),
(9, 2, 22),(9, 3, 11),
(10, 4, 19),(10, 5, 15),(11, 1, 7),(11, 2, 23),
(12, 3, 9),(12, 4, 21),(13, 5, 16),(13, 1, 8),(14, 2, 20),(14, 3, 12),
(15, 4, 25),(15, 5, 30),(16, 1, 18),(16, 2, 11),(17, 3, 13),
(17, 4, 22),(18, 5, 17),
(18, 1, 7),(19, 2, 24),(19, 3, 10),(20, 4, 20),(20, 5, 19),(21, 1, 5),(21, 2, 30),(22, 3, 8),
(22, 4, 15),(23, 5, 12),(23, 1, 14),(24, 2, 27),(24, 3, 10),
(25, 4, 22),(25, 5, 13),(26, 1, 15),(26, 2, 20),(26, 3, 10),
(26, 4, 25),(27, 1, 12),(27, 2, 18),(27, 3, 15),(27, 4, 30),(27, 5, 20),
(28, 1, 20),(28, 2, 25),
(28, 5, 22),(29, 1, 18),(29, 2, 22),(29, 3, 20),(29, 4, 28),(29, 5, 15),
(30, 1, 20),(30, 2, 25),(30, 3, 15),(30, 4, 10),(30, 5, 22),
(31, 1, 18),(31, 2, 22),(31, 3, 20),(31, 4, 28),(31, 5, 15),
(32, 1, 12),(32, 2, 20),(32, 3, 15),
(32, 4, 30),(32, 5, 20),
(33, 1, 20),(33, 2, 25),(33, 3, 15),(33, 4, 10),(33, 5, 22),
(34, 1, 12), (34, 2, 20), (34, 3, 15), (34, 4, 30), (34, 5, 20),
(35, 1, 20), (35, 2, 25), (35, 3, 15), (35, 4, 10), (35, 5, 22),
(36, 1, 12), (36, 2, 20), (36, 3, 15), (36, 4, 30), (36, 5, 20),
(37, 1, 20), (37, 2, 25), (37, 3, 15), (37, 4, 10), (37, 5, 22),
(38, 1, 12), (38, 2, 20), (38, 3, 15), (38, 4, 30), (38, 5, 20),
(39, 1, 20), (39, 2, 25), (39, 3, 15), (39, 4, 10), (39, 5, 22),
(40, 1, 12), (40, 2, 20), (40, 3, 15), (40, 4, 30), (40, 5, 20),
(41, 1, 20), (41, 2, 25), (41, 3, 15), (41, 4, 10), (41, 5, 22),
(42, 1, 12), (42, 2, 20), (42, 3, 15), (42, 4, 30), (42, 5, 20),
(43, 1, 20), (43, 2, 25), (43, 3, 15), (43, 4, 10), (43, 5, 22),
(44, 1, 12), (44, 2, 20), (44, 3, 15), (44, 4, 30), (44, 5, 20),
(45, 1, 20), (45, 2, 25), (45, 3, 15), (45, 4, 10), (45, 5, 22),
(46, 1, 12), (46, 2, 20), (46, 3, 15), (46, 4, 30), (46, 5, 20),
(47, 1, 20), (47, 2, 25), (47, 3, 15), (47, 4, 10), (47, 5, 22),
(48, 1, 12), (48, 2, 20), (48, 3, 15), (48, 4, 30), (48, 5, 20),
(49, 1, 20), (49, 2, 25), (49, 3, 15), (49, 4, 10), (49, 5, 22),
(50, 1, 12), (50, 2, 20), (50, 3, 15), (50, 4, 30), (50, 5, 20),
(51, 1, 20), (51, 2, 25), (51, 3, 15), (51, 4, 10), (51, 5, 22),
(52, 1, 12), (52, 2, 20), (52, 3, 15), (52, 4, 30), (52, 5, 20),
(53, 1, 20), (53, 2, 25), (53, 3, 15), (53, 4, 10), (53, 5, 22),
(54, 1, 12), (54, 2, 20), (54, 3, 15), (54, 4, 30), (54, 5, 20),
(55, 1, 12), (55, 2, 20), (55, 3, 15), (55, 4, 30), (55, 5, 20),
(56, 1, 20), (56, 2, 25), (56, 3, 15), (56, 4, 10), (56, 5, 22),
(57, 1, 12), (57, 2, 20), (57, 3, 15), (57, 4, 30), (57, 5, 20),
(58, 1, 20), (58, 2, 25), (58, 3, 15), (58, 4, 10), (58, 5, 22),
(59, 1, 12), (59, 2, 20), (59, 3, 15), (59, 4, 30), (59, 5, 20),
(60, 1, 20), (60, 2, 25), (60, 3, 15), (60, 4, 10), (60, 5, 22),
(61, 1, 12), (61, 2, 20), (61, 3, 15), (61, 4, 30), (61, 5, 20),
(62, 1, 20), (62, 2, 25), (62, 3, 15), (62, 4, 10), (62, 5, 22),
(63, 1, 12), (63, 2, 20), (63, 3, 15), (63, 4, 30), (63, 5, 20),
(64, 1, 20), (64, 2, 25), (64, 3, 15), (64, 4, 10), (64, 5, 22),
(65, 1, 12), (65, 2, 20), (65, 3, 15), (65, 4, 30), (65, 5, 20),
(66, 1, 20), (66, 2, 25), (66, 3, 15), (66, 4, 10), (66, 5, 22),
(67, 1, 12), (67, 2, 20), (67, 3, 15), (67, 4, 30), (67, 5, 20),
(68, 1, 20), (68, 2, 25), (68, 3, 15), (68, 4, 10), (68, 5, 22),
(69, 1, 12), (69, 2, 20), (69, 3, 15), (69, 4, 30), (69, 5, 20),
(70, 1, 20), (70, 2, 25), (70, 3, 15), (70, 4, 10), (70, 5, 22);



--status Ordered
INSERT INTO OUTORDERSTATUS (date_ordersales_status_changed, orderID, status_id) VALUES
('2023-11-02 00:00:00.000', 1, 1),
('2023-11-05 00:00:00.000', 2, 1),
('2023-11-07 00:00:00.000', 3, 1),
('2023-11-09 00:00:00.000', 4, 1),
('2023-11-12 00:00:00.000', 5, 1),
('2023-11-12 00:00:00.000', 6, 1),
('2023-11-14 00:00:00.000', 7, 1),
('2023-11-15 00:00:00.000', 8, 1),
('2023-11-16 00:00:00.000', 9, 1),
('2023-11-17 00:00:00.000', 10, 1),
('2023-11-19 00:00:00.000', 11, 1),
('2023-11-19 00:00:00.000', 12, 1),
('2023-11-21 00:00:00.000', 13, 1),
('2023-11-22 00:00:00.000', 14, 1),
('2023-11-23 00:00:00.000', 15, 1),
('2023-11-24 00:00:00.000', 16, 1),
('2023-11-24 00:00:00.000', 17, 1),
('2023-11-26 00:00:00.000', 18, 1),
('2023-11-26 00:00:00.000', 19, 1),
('2023-11-28 00:00:00.000', 20, 1),
('2023-11-29 00:00:00.000', 21, 1),
('2023-11-30 00:00:00.000', 22, 1),
('2023-12-01 00:00:00.000', 23, 1),
('2023-12-01 00:00:00.000', 24, 1),
('2023-12-03 00:00:00.000', 25, 1),
('2023-12-03 00:00:00.000', 26, 1),
('2023-12-04 00:00:00.000', 27, 1),
('2023-12-05 00:00:00.000', 28, 1),
('2023-12-06 00:00:00.000', 29, 1),
('2023-12-07 00:00:00.000', 30, 1),
('2023-12-08 00:00:00.000', 31, 1),
('2023-12-09 00:00:00.000', 32, 1),
('2023-12-10 00:00:00.000', 33, 1),
('2023-12-10 00:00:00.000', 34, 1),
('2023-12-11 00:00:00.000', 35, 1),
('2023-12-12 00:00:00.000', 36, 1),
('2023-12-13 00:00:00.000', 37, 1),
('2023-12-14 00:00:00.000', 38, 1),
('2023-12-15 00:00:00.000', 39, 1),
('2023-12-15 00:00:00.000', 40, 1),
('2023-12-17 00:00:00.000', 41, 1),
('2023-12-19 00:00:00.000', 42, 1),
('2023-12-19 00:00:00.000', 43, 1),
('2023-12-20 00:00:00.000', 44, 1),
('2023-12-20 00:00:00.000', 45, 1),
('2023-12-22 00:00:00.000', 46, 1),
('2023-12-22 00:00:00.000', 47, 1),
('2023-12-23 00:00:00.000', 48, 1),
('2023-12-24 00:00:00.000', 49, 1),
('2023-12-25 00:00:00.000', 50, 1),
('2023-12-28 00:00:00.000', 51, 1),
('2023-12-29 00:00:00.000', 52, 1),
('2023-12-30 00:00:00.000', 53, 1),
('2023-12-31 00:00:00.000', 54, 1),
('2024-01-01 00:00:00.000', 55, 1),
('2024-01-02 00:00:00.000', 56, 1),
('2024-01-02 00:00:00.000', 57, 1),
('2024-01-03 00:00:00.000', 58, 1),
('2024-01-05 00:00:00.000', 59, 1),
('2024-01-06 00:00:00.000', 60, 1),
('2024-01-07 00:00:00.000', 61, 1),
('2024-01-08 00:00:00.000', 62, 1),
('2024-01-10 00:00:00.000', 63, 1),
('2024-01-11 00:00:00.000', 64, 1),
('2024-01-11 00:00:00.000', 65, 1),
('2024-01-12 00:00:00.000', 66, 1),
('2024-01-13 00:00:00.000', 67, 1),
('2024-01-14 00:00:00.000', 68, 1),
('2024-01-15 00:00:00.000', 69, 1),
('2024-01-17 00:00:00.000', 70, 1);



--after ~5 days status In Production
INSERT INTO OUTORDERSTATUS (date_ordersales_status_changed, orderID, status_id) VALUES
('2023-11-07 00:00:00.000', 1, 2),
('2023-11-10 00:00:00.000', 2, 2),
('2023-11-12 00:00:00.000', 3, 2),
('2023-11-13 00:00:00.000', 4, 2),
('2023-11-17 00:00:00.000', 5, 2),
('2023-11-17 00:00:00.000', 6, 2),
('2023-11-19 00:00:00.000', 7, 2),
('2023-11-20 00:00:00.000', 8, 2),
('2023-11-21 00:00:00.000', 9, 2),
('2023-11-22 00:00:00.000', 10, 2),
('2023-11-24 00:00:00.000', 11, 2),
('2023-11-25 00:00:00.000', 12, 2),
('2023-11-26 00:00:00.000', 13, 2),
('2023-11-27 00:00:00.000', 14, 2),
('2023-11-28 00:00:00.000', 15, 2),
('2023-11-29 00:00:00.000', 16, 2),
('2023-11-30 00:00:00.000', 17, 2),
('2023-12-01 00:00:00.000', 18, 2),
('2023-12-01 00:00:00.000', 19, 2),
('2023-12-03 00:00:00.000', 20, 2),
('2023-12-04 00:00:00.000', 21, 2),
('2023-12-05 00:00:00.000', 22, 2),
('2023-12-06 00:00:00.000', 23, 2),
('2023-12-07 00:00:00.000', 24, 2),
('2023-12-08 00:00:00.000', 25, 2),
('2023-12-08 00:00:00.000', 26, 2),
('2023-12-10 00:00:00.000', 27, 2),
('2023-12-11 00:00:00.000', 28, 2),
('2023-12-12 00:00:00.000', 29, 2),
('2023-12-13 00:00:00.000', 30, 2),
('2023-12-14 00:00:00.000', 31, 2),
('2023-12-14 00:00:00.000', 32, 2),
('2023-12-16 00:00:00.000', 33, 2),
('2023-12-16 00:00:00.000', 34, 2),
('2023-12-17 00:00:00.000', 35, 2),
('2023-12-18 00:00:00.000', 36, 2),
('2023-12-19 00:00:00.000', 37, 2),
('2023-12-20 00:00:00.000', 38, 2),
('2023-12-21 00:00:00.000', 39, 2),
('2023-12-22 00:00:00.000', 40, 2),
('2023-12-22 00:00:00.000', 41, 2),
('2023-12-22 00:00:00.000', 42, 2),
('2023-12-24 00:00:00.000', 43, 2),
('2023-12-26 00:00:00.000', 44, 2),
('2023-12-27 00:00:00.000', 45, 2),
('2023-12-28 00:00:00.000', 46, 2),
('2023-12-29 00:00:00.000', 47, 2),
('2023-12-29 00:00:00.000', 48, 2),
('2023-12-31 00:00:00.000', 49, 2),
('2024-01-01 00:00:00.000', 50, 2),
('2024-01-02 00:00:00.000', 51, 2),
('2024-01-03 00:00:00.000', 52, 2),
('2024-01-04 00:00:00.000', 53, 2),
('2024-01-05 00:00:00.000', 54, 2),
('2024-01-05 00:00:00.000', 55, 2),
('2024-01-07 00:00:00.000', 56, 2),
('2024-01-08 00:00:00.000', 57, 2),
('2024-01-09 00:00:00.000', 58, 2),
('2024-01-10 00:00:00.000', 59, 2),
('2024-01-12 00:00:00.000', 60, 2),
('2024-01-12 00:00:00.000', 61, 2),
('2024-01-14 00:00:00.000', 62, 2),
('2024-01-15 00:00:00.000', 63, 2),
('2024-01-16 00:00:00.000', 64, 2),
('2024-01-17 00:00:00.000', 65, 2),
('2024-01-19 00:00:00.000', 66, 2),
('2024-01-20 00:00:00.000', 67, 2),
('2024-01-22 00:00:00.000', 68, 2),
('2024-01-22 00:00:00.000', 69, 2),
('2024-01-24 00:00:00.000', 70, 2);

-- afterr ~2 days status Ready to Deliver
INSERT INTO OUTORDERSTATUS (date_ordersales_status_changed, orderID, status_id) VALUES
('2023-11-09 00:00:00.000', 1, 3),
('2023-11-12 00:00:00.000', 2, 3),
('2023-11-14 00:00:00.000', 3, 3),
('2023-11-16 00:00:00.000', 4, 3),
('2023-11-19 00:00:00.000', 5, 3),
('2023-11-19 00:00:00.000', 6, 3),
('2023-11-21 00:00:00.000', 7, 3),
('2023-11-22 00:00:00.000', 8, 3),
('2023-11-23 00:00:00.000', 9, 3),
('2023-11-24 00:00:00.000', 10, 3),
('2023-11-26 00:00:00.000', 11, 3),
('2023-11-26 00:00:00.000', 12, 3),
('2023-11-28 00:00:00.000', 13, 3),
('2023-11-29 00:00:00.000', 14, 3),
('2023-11-30 00:00:00.000', 15, 3),
('2023-12-01 00:00:00.000', 16, 3),
('2023-12-01 00:00:00.000', 17, 3),
('2023-12-03 00:00:00.000', 18, 3),
('2023-12-03 00:00:00.000', 19, 3),
('2023-12-04 00:00:00.000', 20, 3),
('2023-12-05 00:00:00.000', 21, 3),
('2023-12-06 00:00:00.000', 22, 3),
('2023-12-07 00:00:00.000', 23, 3),
('2023-12-08 00:00:00.000', 24, 3),
('2023-12-08 00:00:00.000', 25, 3),
('2023-12-10 00:00:00.000', 26, 3),
('2023-12-11 00:00:00.000', 27, 3),
('2023-12-12 00:00:00.000', 28, 3),
('2023-12-13 00:00:00.000', 29, 3),
('2023-12-14 00:00:00.000', 30, 3),
('2023-12-14 00:00:00.000', 31, 3),
('2023-12-16 00:00:00.000', 32, 3),
('2023-12-16 00:00:00.000', 33, 3),
('2023-12-17 00:00:00.000', 34, 3),
('2023-12-18 00:00:00.000', 35, 3),
('2023-12-19 00:00:00.000', 36, 3),
('2023-12-20 00:00:00.000', 37, 3),
('2023-12-21 00:00:00.000', 38, 3),
('2023-12-22 00:00:00.000', 39, 3),
('2023-12-22 00:00:00.000', 40, 3),
('2023-12-24 00:00:00.000', 41, 3),
('2023-12-24 00:00:00.000', 42, 3),
('2023-12-25 00:00:00.000', 43, 3),
('2023-12-27 00:00:00.000', 44, 3),
('2023-12-28 00:00:00.000', 45, 3),
('2023-12-29 00:00:00.000', 46, 3),
('2023-12-29 00:00:00.000', 47, 3),
('2023-12-31 00:00:00.000', 48, 3),
('2024-01-02 00:00:00.000', 49, 3),
('2024-01-02 00:00:00.000', 50, 3),
('2024-01-03 00:00:00.000', 51, 3),
('2024-01-04 00:00:00.000', 52, 3),
('2024-01-05 00:00:00.000', 53, 3),
('2024-01-08 00:00:00.000', 54, 3),
('2024-01-08 00:00:00.000', 55, 3),
('2024-01-08 00:00:00.000', 56, 3),
('2024-01-09 00:00:00.000', 57, 3),
('2024-01-10 00:00:00.000', 58, 3),
('2024-01-12 00:00:00.000', 59, 3),
('2024-01-12 00:00:00.000', 60, 3),
('2024-01-14 00:00:00.000', 61, 3),
('2024-01-16 00:00:00.000', 62, 3),
('2024-01-16 00:00:00.000', 63, 3),
('2024-01-17 00:00:00.000', 64, 3),
('2024-01-19 00:00:00.000', 65, 3),
('2024-01-20 00:00:00.000', 66, 3),
('2024-01-26 00:00:00.000', 67, 3),
('2024-02-22 00:00:00.000', 68, 3),
('2024-02-23 00:00:00.000', 69, 3),
('2024-03-25 00:00:00.000', 70, 3),
('2023-11-12 00:00:00.000', 1, 4),
('2023-11-13 00:00:00.000', 2, 4),
('2023-11-15 00:00:00.000', 3, 4),
('2023-11-17 00:00:00.000', 4, 4),
('2023-11-20 00:00:00.000', 5, 4),
('2023-11-20 00:00:00.000', 6, 4),
('2023-11-22 00:00:00.000', 7, 4),
('2023-11-23 00:00:00.000', 8, 4),
('2023-11-24 00:00:00.000', 9, 4),
('2023-11-25 00:00:00.000', 10, 4),
('2023-11-27 00:00:00.000', 11, 4),
('2023-11-27 00:00:00.000', 12, 4),
('2023-11-29 00:00:00.000', 13, 4),
('2023-11-30 00:00:00.000', 14, 4),
('2023-12-01 00:00:00.000', 15, 4),
('2023-12-02 00:00:00.000', 16, 4),
('2023-12-02 00:00:00.000', 17, 4),
('2023-12-04 00:00:00.000', 18, 4),
('2023-12-04 00:00:00.000', 19, 4),
('2023-12-05 00:00:00.000', 20, 4),
('2023-12-06 00:00:00.000', 21, 4),
('2023-12-07 00:00:00.000', 22, 4),
('2023-12-08 00:00:00.000', 23, 4),
('2023-12-09 00:00:00.000', 24, 4),
('2023-12-09 00:00:00.000', 25, 4),
('2023-12-11 00:00:00.000', 26, 4),
('2023-12-12 00:00:00.000', 27, 4),
('2023-12-13 00:00:00.000', 28, 4),
('2023-12-14 00:00:00.000', 29, 4),
('2023-12-15 00:00:00.000', 30, 4),
('2023-12-15 00:00:00.000', 31, 4),
('2023-12-17 00:00:00.000', 32, 4),
('2023-12-17 00:00:00.000', 33, 4),
('2023-12-18 00:00:00.000', 34, 4),
('2023-12-19 00:00:00.000', 35, 4),
('2023-12-20 00:00:00.000', 36, 4),
('2023-12-21 00:00:00.000', 37, 4),
('2023-12-22 00:00:00.000', 38, 4),
('2023-12-22 00:00:00.000', 39, 4),
('2023-12-24 00:00:00.000', 40, 4),
('2023-12-24 00:00:00.000', 41, 4),
('2023-12-26 00:00:00.000', 42, 4),
('2023-12-27 00:00:00.000', 43, 4),
('2023-12-28 00:00:00.000', 44, 4),
('2023-12-29 00:00:00.000', 45, 4),
('2023-12-29 00:00:00.000', 46, 4),
('2023-12-31 00:00:00.000', 47, 4),
('2024-01-01 00:00:00.000', 48, 4),
('2024-01-02 00:00:00.000', 49, 4),
('2024-01-03 00:00:00.000', 50, 4),
('2024-01-04 00:00:00.000', 51, 4),
('2024-01-05 00:00:00.000', 52, 4),
('2024-01-05 00:00:00.000', 53, 4),
('2024-01-07 00:00:00.000', 54, 4),
('2024-01-08 00:00:00.000', 55, 4),
('2024-01-09 00:00:00.000', 56, 4),
('2024-01-10 00:00:00.000', 57, 4),
('2024-01-12 00:00:00.000', 58, 4),
('2024-01-12 00:00:00.000', 59, 4),
('2024-01-14 00:00:00.000', 60, 4),
('2024-01-15 00:00:00.000', 61, 4),
('2024-01-16 00:00:00.000', 62, 4),
('2024-01-17 00:00:00.000', 63, 4),
('2024-01-19 00:00:00.000', 64, 4),
('2024-01-20 00:00:00.000', 65, 6),
('2024-01-21 00:00:00.000', 66, 4),
('2024-01-22 00:00:00.000', 67, 4),
('2024-01-24 00:00:00.000', 68, 6),
('2024-01-25 00:00:00.000', 69, 4),
('2024-01-26 00:00:00.000', 70, 6);


-- status Completed

-- status In Delivery
INSERT INTO OUTORDERSTATUS (date_ordersales_status_changed, orderID, status_id) VALUES
('2023-11-14 00:00:00.000', 1, 5),
('2023-11-15 00:00:00.000', 2, 5),
('2023-11-17 00:00:00.000', 3, 5),
('2023-11-19 00:00:00.000', 4, 5),
('2023-11-22 00:00:00.000', 5, 5),
('2023-11-22 00:00:00.000', 6, 5),
('2023-11-24 00:00:00.000', 7, 5),
('2023-11-25 00:00:00.000', 8, 5),
('2023-11-26 00:00:00.000', 9, 5),
('2023-11-27 00:00:00.000', 10, 5),
('2023-11-29 00:00:00.000', 11, 5),
('2023-11-29 00:00:00.000', 12, 5),
('2023-12-01 00:00:00.000', 13, 5),
('2023-12-02 00:00:00.000', 14, 5),
('2023-12-03 00:00:00.000', 15, 5),
('2023-12-04 00:00:00.000', 16, 5),
('2023-12-04 00:00:00.000', 17, 5),
('2023-12-06 00:00:00.000', 18, 5),
('2023-12-06 00:00:00.000', 19, 5),
('2023-12-07 00:00:00.000', 20, 5),
('2023-12-08 00:00:00.000', 21, 5),
('2023-12-09 00:00:00.000', 22, 5),
('2023-12-10 00:00:00.000', 23, 5),
('2023-12-11 00:00:00.000', 24, 5),
('2023-12-11 00:00:00.000', 25, 5),
('2023-12-13 00:00:00.000', 26, 5),
('2023-12-14 00:00:00.000', 27, 5),
('2023-12-15 00:00:00.000', 28, 5),
('2023-12-16 00:00:00.000', 29, 5),
('2023-12-17 00:00:00.000', 30, 5),
('2023-12-17 00:00:00.000', 31, 5),
('2023-12-19 00:00:00.000', 32, 5),
('2023-12-19 00:00:00.000', 33, 5),
('2023-12-20 00:00:00.000', 34, 5),
('2023-12-21 00:00:00.000', 35, 5),
('2023-12-22 00:00:00.000', 36, 5),
('2023-12-23 00:00:00.000', 37, 5),
('2023-12-24 00:00:00.000', 38, 5),
('2023-12-24 00:00:00.000', 39, 5),
('2023-12-26 00:00:00.000', 40, 5),
('2023-12-26 00:00:00.000', 41, 5),
('2023-12-28 00:00:00.000', 42, 5),
('2023-12-29 00:00:00.000', 43, 5),
('2023-12-30 00:00:00.000', 44, 5),
('2024-01-01 00:00:00.000', 45, 5),
('2024-01-01 00:00:00.000', 46, 5),
('2024-01-02 00:00:00.000', 47, 5),
('2024-01-03 00:00:00.000', 48, 5),
('2024-01-04 00:00:00.000', 49, 5),
('2024-01-05 00:00:00.000', 50, 5),
('2024-01-06 00:00:00.000', 51, 5),
('2024-01-07 00:00:00.000', 52, 5),
('2024-01-07 00:00:00.000', 53, 5),
('2024-01-09 00:00:00.000', 54, 5),
('2024-01-10 00:00:00.000', 55, 5),
('2024-01-11 00:00:00.000', 56, 5),
('2024-01-12 00:00:00.000', 57, 5),
('2024-01-14 00:00:00.000', 58, 5),
('2024-01-14 00:00:00.000', 59, 5),
('2024-01-16 00:00:00.000', 60, 5),
('2024-01-17 00:00:00.000', 61, 5),
('2024-01-18 00:00:00.000', 62, 5),
('2024-01-19 00:00:00.000', 63, 5),
('2024-01-21 00:00:00.000', 64, 5),
('2024-01-23 00:00:00.000', 66, 5),
('2024-01-24 00:00:00.000', 67, 5),
('2024-01-26 00:00:00.000', 69, 5);





-- ����������� �������� �� ��� ������������� ����� ��� ��� ����� repID ����� ��� ����� shiftID
INSERT INTO QUALITY_CONTROL (resultID, report_date)
VALUES
(1, '2023-11-09 00:00:00.000'),
(1, '2023-11-12 00:00:00.000'),
(1, '2023-11-14 00:00:00.000'),
(2, '2023-11-16 00:00:00.000'),
(2, '2023-11-19 00:00:00.000'),
(2, '2023-11-19 00:00:00.000'),
(1, '2023-11-21 00:00:00.000'),
(1, '2023-11-22 00:00:00.000'),
(2, '2023-11-23 00:00:00.000'),
(2, '2023-11-24 00:00:00.000'),
(1, '2023-11-26 00:00:00.000'),
(2, '2023-11-26 00:00:00.000'),
(4, '2023-11-28 00:00:00.000'),
(4, '2023-11-29 00:00:00.000'),
(4, '2023-11-30 00:00:00.000'),
(4, '2023-12-01 00:00:00.000'),
(4, '2023-12-01 00:00:00.000'),
(3, '2023-12-03 00:00:00.000'),
(3, '2023-12-03 00:00:00.000'),
(3, '2023-12-04 00:00:00.000'),
(3, '2023-12-05 00:00:00.000'),
(2, '2023-12-06 00:00:00.000'),
(2, '2023-12-07 00:00:00.000'),
(1, '2023-12-08 00:00:00.000'),
(1, '2023-12-08 00:00:00.000'),
(1, '2023-12-10 00:00:00.000'),
(1, '2023-12-11 00:00:00.000'),
(3, '2023-12-12 00:00:00.000'),
(3, '2023-12-13 00:00:00.000'),
(4, '2023-12-14 00:00:00.000'),
(4, '2023-12-14 00:00:00.000'),
(4, '2023-12-16 00:00:00.000'),
(4, '2023-12-16 00:00:00.000'),
(1, '2023-12-17 00:00:00.000'),
(1, '2023-12-18 00:00:00.000'),
(2, '2023-12-19 00:00:00.000'),
(2, '2023-12-20 00:00:00.000'),
(3, '2023-12-21 00:00:00.000'),
(3, '2023-12-22 00:00:00.000'),
(2, '2023-12-22 00:00:00.000'),
(3, '2023-12-24 00:00:00.000'),
(3, '2023-12-24 00:00:00.000'),
(4, '2023-12-26 00:00:00.000'),
(4, '2023-12-27 00:00:00.000'),
(4, '2023-12-28 00:00:00.000'),
(4, '2023-12-29 00:00:00.000'),
(4, '2023-12-29 00:00:00.000'),
(4, '2023-12-31 00:00:00.000'),
(1, '2024-01-02 00:00:00.000'),
(1, '2024-01-02 00:00:00.000'),
(2, '2024-01-03 00:00:00.000'),
(2, '2024-01-04 00:00:00.000'),
(2, '2024-01-05 00:00:00.000'),
(2, '2024-01-05 00:00:00.000'),
(3, '2024-01-08 00:00:00.000'),
(3, '2024-01-08 00:00:00.000'),
(3, '2024-01-09 00:00:00.000'),
(2, '2024-01-10 00:00:00.000'),
(2, '2024-01-12 00:00:00.000'),
(3, '2024-01-12 00:00:00.000'),
(1, '2024-01-14 00:00:00.000'),
(1, '2024-01-15 00:00:00.000'),
(2, '2024-01-16 00:00:00.000'),
(2, '2024-01-17 00:00:00.000'),
(3, '2024-01-19 00:00:00.000'),
(3, '2024-01-20 00:00:00.000'),
(4, '2024-01-26 00:00:00.000'),
(4, '2024-02-22 00:00:00.000'),
(4, '2024-02-24 00:00:00.000'),
(4, '2024-03-25 00:00:00.000');


INSERT INTO PRODUCTION (orderID, shiftID, repID) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 1, 4),
(5, 2, 5),
(6, 3, 6),
(7, 1, 7),
(8, 2, 8),
(9, 3, 9),
(10, 1, 10),
(11, 2, 11),
(12, 3, 12),
(13, 1, 13),
(14, 2, 14),
(15, 3, 15),
(16, 1, 16),
(17, 2, 17),
(18, 3, 18),
(19, 1, 19),
(20, 2, 20),
(21, 3, 21),
(22, 1, 22),
(23, 2, 23),
(24, 3, 24),
(25, 1, 25),
(26, 2, 26),
(27, 3, 27),
(28, 1, 28),
(29, 2, 29),
(30, 3, 30),
(31, 1, 31),
(32, 2, 32),
(33, 3, 33),
(34, 1, 34),
(35, 2, 35),
(36, 3, 36),
(37, 1, 37),
(38, 2, 38),
(39, 3, 39),
(40, 1, 40),
(41, 2, 41),
(42, 3, 42),
(43, 1, 43),
(44, 2, 44),
(45, 3, 45),
(46, 1, 46),
(47, 2, 47),
(48, 3, 48),
(49, 1, 49),
(50, 2, 50),
(51, 3, 51),
(52, 1, 52),
(53, 2, 53),
(54, 3, 54),
(55, 1, 55),
(56, 2, 56),
(57, 3, 57),
(58, 1, 58),
(59, 2, 59),
(60, 3, 60),
(61, 1, 61),
(62, 2, 62),
(63, 3, 63),
(64, 1, 64),
(65, 2, 65),
(66, 3, 66),
(67, 1, 67),
(68, 2, 68),
(69, 3, 69),
(70, 1, 70);




INSERT INTO ORDERS_FOR_RAW_MATERIALS (supplier_ID) VALUES
(3),
(1),
(5),
(2),
(4),
(1),
(2),
(3),
(4),
(5);


INSERT INTO RAW_MATERIALS_ORDERS_RAW_MATERIALS (units, rmorderID, rawMatID)
VALUES
(100, 1, 1),  
(200, 1, 2),  
(150, 2, 11),  
(120, 3, 14),  
(180, 3, 11),  
(100, 4, 13),  
(200, 4,12),  
(150, 5, 8),  
(120, 6, 9),  
(180, 6, 10);  


-- STATUS FOR ORDER OF RAW MATERIALS (ORDERED)
INSERT INTO RAW_MATERIALS_ORDER_STATUS (date_of_status_change, rmorderID, status_id) VALUES
('2023-10-02 00:00:00.000', 1, 1),
('2023-10-05 00:00:00.000', 2, 1),
('2023-11-01 00:00:00.000', 3, 1),
('2023-11-10 00:00:00.000', 4, 1),
('2023-11-12 00:00:00.000', 5, 1),
('2023-11-13 00:00:00.000', 6, 1),
('2023-11-14 00:00:00.000', 7, 1),
('2023-11-14 00:00:00.000', 8, 1),
('2023-11-28 00:00:00.000', 9, 1),
('2023-12-17 00:00:00.000', 10, 1);


-- STATUS FOR ORDER OF RAW MATERIALS (COMPLETED), ACTUALLY THE DAY WHWERE THE FACTORY RECEIVED THE ORDERS.
INSERT INTO RAW_MATERIALS_ORDER_STATUS (date_of_status_change, rmorderID, status_id) VALUES
('2023-10-08 00:00:00.000', 1, 5),
('2023-10-09 00:00:00.000', 2, 5),
('2023-11-05 00:00:00.000', 3, 5),
('2023-11-20 00:00:00.000', 4, 5),
('2023-11-21 00:00:00.000', 5, 5),
('2023-11-23 00:00:00.000', 6, 5),
('2023-11-23 00:00:00.000', 7, 5),
('2023-11-29 00:00:00.000', 8, 5),
('2023-12-01 00:00:00.000', 9, 5),
('2023-12-19 00:00:00.000', 10, 5);