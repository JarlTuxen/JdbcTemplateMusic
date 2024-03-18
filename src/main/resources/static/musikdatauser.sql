CREATE USER musicdata_user@localhost IDENTIFIED BY 'Dat23B';
GRANT SELECT, INSERT, DELETE, UPDATE
    ON musicdata.*
    TO musicdata_user@localhost;
SHOW GRANTS FOR musicdata_user@localhost