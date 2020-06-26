// for some reason no need for document.onload

function output(inp) {
    document.body.appendChild(document.createElement('pre')).innerHTML = inp;
}
fetch('/display-request-data')
 .then(response => response.json())
 .then(data => output(JSON.stringify(data, undefined, 4)));
