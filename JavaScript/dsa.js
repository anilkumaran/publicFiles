async fetchDate() {
    let data = await fetch('https://worldtimeapi.org/api/timezone/Etc/UTC');
    let json = await data.json();
    return json.datetime;
}