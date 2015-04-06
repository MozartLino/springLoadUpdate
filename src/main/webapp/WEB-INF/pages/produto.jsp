<html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<body>
	<h1>Message : ${message}</h1>


    <form action="produto/salvar">
        <input name="nome" value="teste">
        <input name="fornecedores[0].nome" value="teste">
    </form>

</body>
</html>