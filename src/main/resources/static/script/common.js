const Storage = localStorage;
const client_param = {
    client_id: 'demo',
    client_secret: 'control_123456',
    redirect_uri: 'http://localhost:7000/login',
    response_type: 'code',
    grant_type: 'authorization_code',
    authorization_uri: `http://localhost:8888/oauth-server/oauth/authorize`,
    access_token_uri: `http://localhost:8888/oauth-server/oauth/token`,
    user_info_uri: `http://localhost:8888/oauth-server/user/info`,
    jwt_key_uri: `http://localhost:8888/oauth-server/oauth/token_key`

}

const Utils = {
    urlParam: (url) => {
        let params = url.split("?")[1].split("&")
        let obj = {}
        params.map(v => obj[v.split("=")[0]] = v.split("=")[1]);
        return obj;
    },
    fetch: (url, data, type) => {
        return new Promise(((resolve, reject) => {
            $.ajax(url, {
                type, data,
                dataType:'json',
                contentType:'application/json',
                success: resolve,
                error: reject
            })
        }));
    }
}