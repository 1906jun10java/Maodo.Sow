
window.onload = function() {
    let myDivs = document.getElementsByTagName("div");

    var book = {
            title: "Le ventre de l'Atlantique",
            genre: "Roman",   
            coverimage: "My img",
            author : function() {
            return this.firstName + " " + this.lastName;
            }
    };
    document.getElementById("Send").addEventListener("click", function() {
        let b0 = document.getElementById("title").value;
        let b1= document.getElementById("author").value;
        let b2 = document.getElementById("coverimage").value;
        let b3 = document.getElementById("genre").value;
       
    });
}
