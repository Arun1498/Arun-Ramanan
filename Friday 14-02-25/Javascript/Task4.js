<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prompt</title>
</head>
<body>
    <h1>Prompt </h1>
    <button onclick="askAddress()">Click to Enter Your Address</button>
    <script>
        function askAddress() {
            let address = prompt("Please enter your address:");
            if (address != null) {
                alert("Your address is: " + address);
            }
        }
    </script>
</body>
</html>
