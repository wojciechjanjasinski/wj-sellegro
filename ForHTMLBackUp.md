
    <form action="/auctions" method="get" th:object="${filters}">
        <input type="text" placeholder="Tytuł aukcji" th:field="*{title}">
        <input type="text" placeholder="Producent" th:field="*{carMaker}">
        <input type="text" placeholder="Marka" th:field="*{carModel}">
        <input type="text" placeholder="Kolor" th:field="*{color}">
        <input type="submit" value="Filtruj" class="btn btn-primary"/>
    </form>