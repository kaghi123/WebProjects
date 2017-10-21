--1. List the names of the top-level (i.e. parent_id is null) files and folders of user cysun. The results should list the folders first, and then the files.
SELECT f.name FROM files f, users u WHERE f.parent_id is null and u.name = 'cysun' and u.id = f.owner_id;

--2. List the names of the files and folders in the folder with id=8.
SELECT name FROM files WHERE id = 8 or parent_id = 8;

--3. Find the name of the parent folder of the file with id=14.
SELECT f1.name From files f1, files f2 WHERE f1.id = f2.parent_id and f2.id = 14;

--4. List the names of all the empty folders.
SELECT f1.name From files f1, files f2 WHERE f1.is_folder is true and f1.id <> f2.parent_id;

--5. Find the number of files (excluding folders) owned by user jdoe.
SELECT f.name From files f, users u WHERE f.is_folder is false and u.name = 'jdoe' and u.id = f.owner_id;

--6. Insert a new folder CS1222 owned by user with id=1 into the folder with id=2.
insert into files values (16, 'CS1222', true, 2, 1);

--7. Change the name of the folder Pictures to Images (assuming there is only one folder whose name is Pictures).
ALTER files RENAME COLUMN Pictures TO Images;

--8. Delete all the files (i.e. not folders) under the folder with id=13.
DELETE FROM files
WHERE parent_id = 13 and is_folder is false;

--9 (Extra Credit +10). List the names of the folder owned by user cysun, and for each folder, the number of files and folders in the folder (or 0 for empty folders).

