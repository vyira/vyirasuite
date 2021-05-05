import {createUseStyles} from "react-jss";
import {Question} from "./Question";
import {AnswerChoice} from "./Answer";
import {useEffect, useState} from "react";
import {get} from "../../utils/api";

const useStyle = createUseStyles({
    root: {
        display: 'flex',
        backgroundColor: 'rgba(250,243,224,0.3)',
        border: 'solid 1px',
        borderColor: 'black',
        borderRadius: 20,
        flexFlow: 'row wrap',
        padding: 5,
        margin: 5
    },
    inner: {
        backgroundColor: 'white',
        padding: 10,
        margin: 10,
        border: 'solid 1px black',
        borderRadius: 10,
    },
    line: {
        border: 'solid 1px black',
        borderLeft: "none",
        height: "auto",
        top: '10%',
        bottom: '10%'
    }
})

const QuestionCard: React.FC<{ questionId: string }> = ({questionId}) => {
    const classes = useStyle()
    const [question, setQuestion] = useState<any>({})
    useEffect(() => {
        let tempData = get(`/question/${questionId}`)
        setQuestion(tempData)
    }, [])
    console.log(question)
    return (
        <div className={classes.root}>
            <div className={classes.inner}>
                <Question question={question.question}/>
            </div>
            <div className={classes.line}/>
            <div className={classes.inner}>
                <AnswerChoice answer={question.answer}/>
            </div>
        </div>
    )
}

export default QuestionCard