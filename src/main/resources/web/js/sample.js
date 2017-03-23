window.jsAPI = {
    echo: function (msg) {
        document.getElementById('demo').innerHTML += msg + " ";
    }
};

function sample() {
    document.getElementById('demo').innerHTML += "hehe cwele ";
    window.JavaAPI.echo("Pozdrowienia dla Javy");
}