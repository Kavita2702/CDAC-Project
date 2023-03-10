const BASE_URL = "http://localhost:8080/api/";
export function httpPost(url,param){
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(param)
    };
    return fetch(BASE_URL+url,requestOptions)
}
export function httpGet(url,param){
    const requestOptions = {
        method: 'Get',
        headers: { 'Content-Type': 'application/json' }
    };
    return fetch(BASE_URL+url+param,requestOptions)
}
export function httpPostwithToken(url,param){
    param['userId'] = localStorage.getItem("user_id");
    const requestOptions = {
        method: 'POST',
        headers: { 
            'Content-Type': 'application/json' ,
            "Authorization":"Bearer "+localStorage.getItem("token")
        },
        body: JSON.stringify(param)
    };
    return fetch(BASE_URL+url,requestOptions)

}
