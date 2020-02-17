INSERT INTO public.scooter_dock(id, available_place, dock_name) VALUES
	(1, 10, 'zachodni'),
	(2, 8, 'wschodni'),
	(3, 5, 'północny'),
	(4, 15, 'południowy');

INSERT INTO public.scooter(id, max_speed, model_name, rental_price, scooter_dock_id, user_account_id) VALUES
    (5, 25, 'ERE-321', 19.99, 1, null),
    (6, 20, 'RTT-43z', 15.50, 1, null),
    (7, 35, 'V-SPEED-1', 29.99, 1, null),
    (8, 40, 'V-SPEED-2', 39.99, 1, null),
    (9, 35, 'V-SPEED-1', 29.99, 2, null),
    (10, 35, 'V-SPEED-1', 29.99, 2, null),
    (11, 25, 'ERE-321', 19.99, 2, null),
    (12, 25, 'ERE-321', 19.99, 2, null),
    (13, 40, 'V-SPEED-2', 39.99, 3, null),
    (14, 35, 'V-SPEED-1', 29.99, 3, null),
    (15, 20, 'RTT-43z', 15.50, 4, null);

SELECT setval('public.hibernate_sequence', 15, true);

