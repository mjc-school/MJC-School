## General

Address service should be a class that manages address book records.

Each record has 3 fields:
1. Integer id - id of a record, must be unique
2. String name - name of the person
3. String address - address of a person

## Expected operations

1. Register new record
2. Get record by id
3. Count records
4. Import records from file in json







## Complex requirements

1. Import records from google account












## Bug

Steps to reproduce:
1. Create a new `AddressRecord`, set its id to `null`
2. Try to add this record to the service

Expected:
1. Exception is thrown

Actual:
1. Nothing is thrown
