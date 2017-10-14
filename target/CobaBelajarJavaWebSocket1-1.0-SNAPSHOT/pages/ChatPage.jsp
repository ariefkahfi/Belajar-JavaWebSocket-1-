<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Chat Page</h4>
    <div id="chatbox">

    </div>
    <table>
        <tr>
            <td>Message</td>
            <td><input type="text" id="message" placeholder="Your Message"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit pesan" onclick="return kirim()"/></td>
        </tr>
    </table>
    <div id="response"></div>
    <a href="<%=request.getContextPath()%>">Home Page</a>
</body>
    <script>
        var ws = new WebSocket('ws://192.168.1.100:8080/CobaBelajarJavaWebSocket1/web-socket');


        ws.onerror = function (event) {
          console.log(event);
        };


        ws.onopen = function (event) {
           document.getElementById('response').innerHTML = "Connected to websocket server and ready to communicate";
        };

        function kirim(){
            if(ws.readyState === WebSocket.OPEN){
                var textPesan = document.getElementById('message').value;
                ws.send(textPesan);
            }
        }



        ws.onmessage = function (p1) {
            var p = document.createElement('p');
            p.innerHTML = p1.data;

            document.getElementById('chatbox').appendChild(p);
            console.log(p1.data);
        };

    </script>
</html>
