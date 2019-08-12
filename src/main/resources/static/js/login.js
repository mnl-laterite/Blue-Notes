let loginButton = document.getElementById('login-button');
let loginForm = document.getElementById('login-form');


loginForm.addEventListener('submit', event => {
    
    event.preventDefault();

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
        
    if (username !== '' && password !== '') {
        let base = btoa(username + ':' + password);

        let request = new XMLHttpRequest();

        request.open('POST','login', true);
        request.setRequestHeader('Authorization', 'Basic ' + base);
        request.onload = function() {
            
            if (request.status == 200) {
                document.location.reload();
            } else {
                document.getElementById('wrong-auth-credentials').style.display = 'block';
            }

        }
        request.send();
    }
    
});
