## Encryption and hashing

1. Topic is very complex, we'll just scratch the surface. Good courses are 20+ hours long
1. Encryption
    1. Definition
    2. Purpose - a lot of data is confidential and we don't want anyone to have access to it. Some data must be protected due to regulatory requirements. This is one of few areas where governments tell you how to write the code
    2. Caesar cipher - https://cryptii.com/pipes/caesar-cipher
        1. It's an example of substitution ciphers, that aren't used widely nowadays
    4. Where encryption is used
        1. Encryption in transit - when you pass your bank card information to the online shop, you should be connected using HTTPS
        2. Encryption at rest -
        3. Encryption in use - rarely used
    5. Main types
        1. Symmetic
        2. Asymmetric
        3. Symmetric examples
            1. XOR - https://md5decrypt.net/en/Xor/#results
            2. AES256 - Bulk algorithm
        4. Asymmetric example
            1. RSA
        5. Comparison symmetric vs asymmetric
    6. TLS flow
    7. Encryption best practices
3. Hash function
    1. Definition
    2. Example - SHA256, https://emn178.github.io/online-tools/sha256.html
    3. Avalanche effect - if you change a single bit the whole hash changes
    4. Hashing applications
        1. Message digest - http://releases.ubuntu.com/21.10/
        2. Password verification
        3. Data structures - not a part of this light talk
    5. Password verification
        1. Why is bad to store them in plaintext
        2. Why simple hashing is a bad idea too, rainbow tables
        3. Salting
        4. BCrypt - https://bcrypt-generator.com/
            1. Supported by Spring
4. Digital signature - private key is used instead of public to sign the data