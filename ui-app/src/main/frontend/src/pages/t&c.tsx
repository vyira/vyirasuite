import React, {useState} from "react";

interface ITnC {
    title: string | null,
    body: string | null
}

const TermsAndCondition: React.FC = () => {
    const [tnc, setTnC] = useState<ITnC>({title: null, body: null})
    fetch("/pages/about").then(res => res.json()).then(data => setTnC(() => {
        return {
            title: data.title,
            body: data.body
        }
    }))
    return (
        <div>
            <div>{tnc.title}</div>
            <div>{tnc.body}</div>
        </div>
    )
}

export default TermsAndCondition