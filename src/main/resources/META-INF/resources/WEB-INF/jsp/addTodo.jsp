<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Add Todo</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div>
            Welcome ${name} 
            <a href="list-todos">Your Todos</a>
            <a href="login"> Logout</a>
        </div>
        <hr>
        <h1>Add a Todo</h1>
        <form action="" method="POST">
            <input type="text" name="description" placeholder="description" required>
            <input type="date" name="targetDate" placeholder="targetDate">
            <input type="submit" value="Add Todo" class="btn btn-success">
        </form>
    </div>
</body>

</html>