import React from 'react'
import {Text} from '@fluentui/react'
import {HeaderProps} from "../../types/header-type";


const Header: React.FC<HeaderProps> = (props) => {
    const {timer, title, user} = props
    const Timer = () => {
        return <div>{timer}</div>
    }
    const Title = () => {
        return <div className={"none"}>{title}</div>
    }
    const User = () => {
        return <div className={"none"}>{user.fullName}</div>
    }
    return (
        <div className={'none'}>
            <div className="ms-Grid" dir={"ltr"}>
                <div className="ms-Grid ms-Grid-row">
                    <div className="ms-Grid-col ms-sm12 ms-md12 ms-lg3">
                        <Text><Timer/></Text>
                    </div>
                    <div className="ms-Grid-col ms-sm12 ms-md12 ms-lg6">
                        <Text><Title/></Text>
                    </div>
                    <div className="ms-Grid-col ms-sm12 ms-md12 ms-lg3">
                        <Text><User/></Text>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Header
