# Persistence Data in Oracle

## PROBLEM

Given the following problem:

A company sells products to several customers. It is necessary to know the personal data of the clients (name, surname, id, address and date of birth). Each product has a name and a code, as well as a unit price. A customer can buy several products from the company, and the same product can be bought by several customers. The products are supplied by different vendors. It must be taken into account that a product can be supplied by more than one supplier, and that a supplier can supply different products. You want to know the NIT, name and address of each provider.

The following conceptual model has been proposed to solve the problem:

Given this information, you must develop the following tasks:

1. Create the database schema in the engine of your choice (Oracle, MySQL).
2. Perform the relational object mapping of said database in a JAVA project. 
3. Create a method that inserts into the database with at least 5 records in each table. 
4. Create a method that allows to consult all the invoices of a client. 
5. CrEate a method that allows consulting the products provided by a supplier. 
6. A method that, based on the seller's id, shows the total value of his sales.
7. Create a method that when entering an invoice identifier displays the following format on the console:
