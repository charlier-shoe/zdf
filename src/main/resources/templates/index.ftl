<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <title>Zun-Doco filc.</title>
        <script type="text/javascript" src="/webjars/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript">
            $(function(){
                var ws = new WebSocket("ws://" + location.host + "/ws");
                ws.onopen = function() {
                };
                ws.onclose = function() {
                };
                ws.onmessage = function(message) {
                    $("#result").append(message.data);
                };
                ws.onerror = function(event) {
                    alert("Failed to connect WebSocket server.");
                };
            });
        </script>
    </head>
    <body>
        <div id="result"></div>
    </body>
</html>