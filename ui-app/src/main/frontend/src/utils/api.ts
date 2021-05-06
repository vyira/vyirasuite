import axios from "axios";

function urlBuilder(url: string) {
    if (process.env.NODE_ENV === "development") {
        return `./db.json`
    } else {
        if (url.startsWith('/')) {
            return `/api/v1${url}`
        } else {
            return `/api/v1/${url}`
        }
    }
}

async function post(url: string, data?: any) {
    return await axios.post(urlBuilder(url), data)
        .then(response => response.data)
        .catch(err => {
            console.error(err)
        });
}

function get(url: string, param?: any) {
    return axios.get(urlBuilder(url))
        .then(response => response.data)
        .catch(err => {
            console.error(err)
        });
}

async function patch(url: string, data: any) {
    return await axios.patch(urlBuilder(url), data)
        .then(response => response.data)
        .catch(err => {
            console.error(err)
        });
}

export {
    get,
    post,
    patch
}