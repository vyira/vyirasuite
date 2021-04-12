import React, {useState} from "react";

const PrivacyPolicy = () => {
    const [privacyPolicy, setPrivacyPolicy] = useState({})
    fetch('/privacyPolicy')
        .then(data => data.json())
        .then(value => setPrivacyPolicy(() => {
            return {
                body: value
            };
        }))
    return <div>{privacyPolicy}</div>
}

export default PrivacyPolicy