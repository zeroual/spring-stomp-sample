var socket = new WebSocket("ws://" + window.location.host + "/websocket/ping");

function ping() {
    socket.send("Ping !");
}
socket.onopen = function () {
    console.log('opening connexion');
    ping();
};

socket.onclose = function () {
    console.log('closing connexion');
};
socket.onmessage = function (message) {
    console.log('message received' + message.data);
    ping();
};