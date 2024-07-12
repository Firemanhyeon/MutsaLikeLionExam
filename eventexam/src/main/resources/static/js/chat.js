const ws = new WebSocket("ws://localhost:8080/ws");

ws.onmessage=(event)=>{
    const chatMessages = document.getElementById("chatMessages");
    const newMessage = document.createElement("div");
    newMessage.textContent = event.data;
    chatMessages.appendChild(newMessage);
}
const sendMessage = () => {
    const message = document.getElementById("message").value;
    ws.send(message);
}

document.getElementById("message").addEventListener('keypress',(event)=>{
    if(event.key==="Enter"){
        event.preventDefault();
        sendMessage();
        document.getElementById("message").value = '';
        document.getElementById("message").focus();
    }
})