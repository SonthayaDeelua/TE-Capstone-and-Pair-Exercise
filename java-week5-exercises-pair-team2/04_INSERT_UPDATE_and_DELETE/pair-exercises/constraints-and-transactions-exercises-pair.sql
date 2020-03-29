-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city (name, population, district, countrycode)
VALUES ('Smallville', 45001, 'Kansas', 'USA') ;

DELETE FROM city
WHERE city.id = 4081;

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001     
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (language, isofficial, countrycode, percentage)
VALUES ('Kryptonese' , false, 'USA', 0.0001);
-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';
-- 4. Set the US captial to Smallville, Kansas in the country table.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Smallville')
WHERE code='USA';
-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE FROM city
WHERE name = 'Smallville';
--this failed the record is tied to anther table because Smallville is the capital. Also Superman would not allow it.

-- 6. Return the US captial to Washington.
UPDATE country
SET capital = (SELECT id FROM city WHERE name = 'Washington, DC')
WHERE code='USA';

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

DELETE FROM city
WHERE name = 'Smallville';

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
UPDATE countrylanguage 
SET isofficial = NOT isofficial
WHERE countrycode in (SELECT code FROM country WHERE indepyear > 1800 and indepyear < 1972);


-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
UPDATE city
SET population = ROUND(population/1000,0);
-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to 
-- square meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
UPDATE country
SET surfacearea = surfacearea /.00000038610
WHERE code in (SELECT countrycode FROM countrylanguage WHERE language = 'French' and percentage >20);