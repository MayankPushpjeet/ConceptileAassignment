CREATE TABLE IF NOT EXISTS QUESTIONS (
                                         ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         QUESTION_TEXT VARCHAR(255),
                                         OPTIONA VARCHAR(255),
                                         OPTIONB VARCHAR(255),
                                         OPTIONC VARCHAR(255),
                                         OPTIOND VARCHAR(255),
                                         CORRECT_ANSWER VARCHAR(255)
);
insert into questions (question_text, optiona, optionb, optionc, optiond, correct_answer) values
                                                                                                  ('What is the capital of France?', 'Paris', 'London', 'Berlin', 'Rome', 'Paris'),
                                                                                                  ('What is 2 + 2?', '3', '4', '5', '6', '4');



