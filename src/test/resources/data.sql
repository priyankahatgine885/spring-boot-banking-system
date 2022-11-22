
INSERT INTO `customer` (`first_name`, `middle_name`, `last_name`, `phone`, `email`,
 `aadhar_number`, `created_dt`, `modified_dt`)
 VALUES ('Akshay', 'Vijay', 'Patil', '9877654656', 'test@gmail.com',
  '8765654567',current_timestamp(), current_timestamp());

INSERT INTO `account`
 (`account_number`, `customer_id`, `account_type`, `balance`, `created_dt`, `modified_dt`)
VALUES ('22222222222222', '1', '1', '2000', current_timestamp(), current_timestamp());
