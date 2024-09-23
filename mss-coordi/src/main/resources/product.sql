INSERT INTO PRODUCT (brand_id, category_id, product_price) VALUES ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 11200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 5500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 4200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 1800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'A'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 5900),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'B'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 6200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1900),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'C'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 5100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2400),
                                                                   ((SELECT id FROM BRAND WHERE name = 'D'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 5000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9900),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'E'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2100)
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 11200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 7200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 4000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1600),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'F'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 1900)
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 5800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3900),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'G'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 10800),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 6300),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2100),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1600),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'H'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2000),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'TOP'), 11400),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'OUTER'), 6700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'BOTTOM'), 3200),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'SNEAKERS'), 9500),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'BAG'), 2400),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'HAT'), 1700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'SOCKS'), 1700),
                                                                   ((SELECT id FROM BRAND WHERE name = 'I'), (SELECT id FROM CATEGORY WHERE name = 'ACCESSORY'), 2400);