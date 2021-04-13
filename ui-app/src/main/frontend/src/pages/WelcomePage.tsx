import React, {useState} from 'react'
import {Spinner, SpinnerSize} from '@fluentui/react'

const WelcomePage: React.FC = () => {
    const [pageDetails, setPageDetails] = useState({pageTitle: "", pageDescription: "", loaded: false})
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
    console.log(pageDetails)
    return pageDetails.loaded ? (
        <div>
            <div>{pageDetails.pageTitle}</div>
            <div>{pageDetails.pageDescription}</div>
        </div>
    ) : (
        <div>
            <Spinner label="Seriously, still loading... 😀" ariaLive="assertive" labelPosition="top" size={SpinnerSize.large}/>
        </div>
    )
}
export default WelcomePage