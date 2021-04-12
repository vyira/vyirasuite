import React, {useState} from "react";

interface IAbout {
    title: string | null,
    body: string | null
}

const About: React.FC = () => {
    const [about, setAbout] = useState<IAbout>({title: null, body: null})
    fetch("/pages/about").then(res => res.json()).then(data => setAbout(() => {
        return {
            title: data.title,
            body: data.body
        }
    }))
    return (
        <div>
            <div>{about.title}</div>
            <div>{about.body}</div>
        </div>
    )
}

export default About