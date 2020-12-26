import React, {useState} from 'react'
import axios from "axios";
import {Spinner} from '@fluentui/react'

const WelcomePage: React.FC = () => {
    const [pageDetails, setPageDetails] = useState({pageTitle: "", pageDescription: "", loaded:false})
    if (!pageDetails.loaded) {
        fetch(`/api/v1/pageDetails?pageTitle=true&pageDescription=true`)
            .then(response => response.json())
            .then(data => setPageDetails({pageTitle: data.pageTitle, pageDescription: data.pageDescription, loaded:true}))
    }
    console.log(pageDetails)
    return pageDetails ? (
        <div>
            <div>{pageDetails.pageTitle}</div>
            <div>{pageDetails.pageDescription}</div>
        </div>
    ) : (
        <div>
            <Spinner label="Seriously, still loading... 😀" ariaLive="assertive" labelPosition="top"/>
        </div>
    )
}
export default WelcomePage