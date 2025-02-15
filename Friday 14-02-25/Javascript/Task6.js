<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prompt</title>
</head>
<body>
    <h1>Prompt </h1>
    <button onclick="askAge()">Click to Enter Your Age</button>
    <script>
        function askAge() {
            let age = prompt("Please enter your age:");
            if (age != null) {
                alert("Your age is: " + age);
            }
        }
    </script>
</body>
</html>
