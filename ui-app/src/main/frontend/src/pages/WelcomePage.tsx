import React, {useEffect, useState} from 'react'
import {Spinner, SpinnerSize} from '@fluentui/react'
import {createUseStyles} from "react-jss";

const useStyle = createUseStyles({
    root: {
        flex: "auto",
        flexDirection: "column",
        alignItems: "center",
        padding: 10,
        margin: 10,
        border: "solid",
        borderColor: '#' + Math.random().toString(16).substr(-6),
        borderWidth: "thin"
    },
    image: {
        alignItems: "center"
    }
})

const PORT = 8081

const socket = new WebSocket(`ws://localhost:${PORT}/ping`)
socket.addEventListener('closed', () => {
    console.log('socket connected')
})

const WelcomePage: React.FC = () => {
    const classes = useStyle()

    const [pageDetails, setPageDetails] = useState({pageTitle: "", pageDescription: "", loaded: false})

    useEffect(() => {
        if (!pageDetails.loaded) {
            if (process.env.NODE_ENV === "development") {
                fetch(`./db.json`)
                    .then(response => new Promise<any>(resolve => {
                        setTimeout(() => resolve(response.json()), 5000)
                    }))
                    .then(actualData => {
                        let data = actualData.pages.welcomePage
                        setPageDetails({
                            pageTitle: data.pageTitle,
                            pageDescription: data.pageDescription,
                            loaded: true
                        })
                    })
            } else {
                fetch(`/api/v1/pageDetails?pageTitle=true&pageDescription=true`)
                    .then(response => response.json())
                    .then(data => setPageDetails({
                        pageTitle: data.pageTitle,
                        pageDescription: data.pageDescription,
                        loaded: true
                    }))
            }
        }
    }, [])

    console.log(pageDetails)
    return pageDetails.loaded ? (
        <div className={classes.root}>
            <div>{pageDetails.pageTitle}</div>
            <div>{pageDetails.pageDescription}</div>
        </div>
    ) : (
        <div className={classes.root}>
            <Spinner label="Seriously, still loading... 😀" ariaLive="assertive" labelPosition="top"
                     size={SpinnerSize.large}/>
        </div>
    )
}
export default WelcomePage