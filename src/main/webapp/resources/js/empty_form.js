function empty_form ()
{
    var txt = document.getElementById('msg').value;
    if(txt == '')
    {
        return false;
    }
    return true;
}

