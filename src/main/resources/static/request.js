function output(inp) {
    document.body.appendChild(document.createElement('pre')).innerHTML = inp;
}
fetch('/api/request')
 .then(response => response.json())
 .then(data => output(JSON.stringify(data, undefined, 4)));
