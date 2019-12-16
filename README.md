# iso8601-deserialization-test
deserialization test application of iso8601 string

This is a sample test application to show how an iso8601 string will be deserialized to a java type.

**Beware** that not all java types are best suited for this conversion, in partisular this application demonstrates how java.time.Instant is not well suited to parse all formats of iso8601.

In order to maximize iso8601 parsability, using java.time.OffsetDateTime is advisable.

Running App.java as java application will print to std output something as below.

```
---------------------------------------------------------------------------------------------
- iso8601 string to java.time.Instant                                                       -
---------------------------------------------------------------------------------------------
[OK] - String 2019-07-10T21:06:53.041292352+0000 converted to Instant -> 2019-07-10T21:06:53.041292352Z
[OK] - String 2019-07-10T21:06:53+0000 converted to Instant -> 2019-07-10T21:06:53Z
[OK] - String 2019-07-10T21:06:53+00:00 converted to Instant -> 2019-07-10T21:06:53Z
[FAIL] - failed to convert string 2019-07-10T21:06:57-07:00 to Instant - Cannot deserialize value of type `java.time.Instant` from String "2019-07-10T21:06:57-07:00": Failed to deserialize java.time.Instant: (java.time.format.DateTimeParseException) Text '2019-07-10T21:06:57-07:00' could not be parsed at index 19
 at [Source: (String)""2019-07-10T21:06:57-07:00""; line: 1, column: 1]
[FAIL] - failed to convert string 2019-07-10T21:06:57+07:00 to Instant - Cannot deserialize value of type `java.time.Instant` from String "2019-07-10T21:06:57+07:00": Failed to deserialize java.time.Instant: (java.time.format.DateTimeParseException) Text '2019-07-10T21:06:57+07:00' could not be parsed at index 19
 at [Source: (String)""2019-07-10T21:06:57+07:00""; line: 1, column: 1]
[OK] - String 2019-07-10T21:07:37.168Z converted to Instant -> 2019-07-10T21:07:37.168Z
[FAIL] - failed to convert string 2019-07-10T21:06:57.123+03:30 to Instant - Cannot deserialize value of type `java.time.Instant` from String "2019-07-10T21:06:57.123+03:30": Failed to deserialize java.time.Instant: (java.time.format.DateTimeParseException) Text '2019-07-10T21:06:57.123+03:30' could not be parsed at index 23
 at [Source: (String)""2019-07-10T21:06:57.123+03:30""; line: 1, column: 1]
[OK] - String 2019-07-10T21:06:53Z converted to Instant -> 2019-07-10T21:06:53Z
[FAIL] - failed to convert string 2019-07-10T21:06:53.041292352+09:00 to Instant - Cannot deserialize value of type `java.time.Instant` from String "2019-07-10T21:06:53.041292352+09:00": Failed to deserialize java.time.Instant: (java.time.format.DateTimeParseException) Text '2019-07-10T21:06:53.041292352+09:00' could not be parsed at index 29
 at [Source: (String)""2019-07-10T21:06:53.041292352+09:00""; line: 1, column: 1]
---------------------------------------------------------------------------------------------
- iso8601 string to java.time.OffsetDateTime                                                -
---------------------------------------------------------------------------------------------
[OK] - String 2019-07-10T21:06:53.041292352+0000 converted to OffsetDateTime -> 2019-07-10T21:06:53.041292352Z
[OK] - String 2019-07-10T21:06:53+0000 converted to OffsetDateTime -> 2019-07-10T21:06:53Z
[OK] - String 2019-07-10T21:06:53+00:00 converted to OffsetDateTime -> 2019-07-10T21:06:53Z
[OK] - String 2019-07-10T21:06:57-07:00 converted to OffsetDateTime -> 2019-07-11T04:06:57Z
[OK] - String 2019-07-10T21:06:57+07:00 converted to OffsetDateTime -> 2019-07-10T14:06:57Z
[OK] - String 2019-07-10T21:07:37.168Z converted to OffsetDateTime -> 2019-07-10T21:07:37.168Z
[OK] - String 2019-07-10T21:06:57.123+03:30 converted to OffsetDateTime -> 2019-07-10T17:36:57.123Z
[OK] - String 2019-07-10T21:06:53Z converted to OffsetDateTime -> 2019-07-10T21:06:53Z
[OK] - String 2019-07-10T21:06:53.041292352+09:00 converted to OffsetDateTime -> 2019-07-10T12:06:53.041292352Z
---------------------------------------------------------------------------------------------

```