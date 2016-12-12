# projzero
There are three different purpose exercises step by step as below:

I. The first exercise for "hello jersey!"
HelloJersey + StartEntity
Function 1:
http://localhost:8080/hello
hello jersey!

II. The second exercise for GET 
MessageServices + MessageResources + StartEntity
Function 1:
http://localhost:8080/message
{"id":"babf4e10-3b78-43d5-a88a-6bc14ded1118","user":"foo","messages":"bar","postedAt":"2016-12-12T16:02:09.002Z"}

III. The third exercise for POST & GET
Message.java(DTO class) + MessageResource + StartEntity
Function 1:
http://localhost:8080/messages
{"id":"8a13f4c0-b8f0-4ee3-a7d8-e391744b9e4d","user":"foo","message":"bar","postedAt":"2016-12-12T15:59:01.615Z"}
Function 2:
curl  -X POST http://localhost:8080/messages -H  "Content-Type: application/json" -d  '{"user":"foo", "message": "bar"}'
{"id":"7f4b1b7a-264e-4282-b4dd-b716e5e40e1f","user":"foo","message":"bar","postedAt":"2016-12-12T15:35:58.003Z"}
