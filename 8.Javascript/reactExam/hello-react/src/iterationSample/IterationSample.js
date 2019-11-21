import React, { useState } from "react";

const IterationSample = () => {
    const [names, setNames] = useState([
        { id: 1, text: "눈사람" },
        { id: 2, text: "얼음" },
        { id: 3, text: "눈" },
        { id: 4, text: "바람" }
    ]);
    const [inputText, setInputText] = useState("");
    const [nextId, setNextId] = useState(5);

    const onChange = e => setInputText(e.target.value);
    const onClick = () => {
        const nextNames = names.concat({
            id: nextId, //nextId 값을 id로 설정
            text: inputText
        });
        setNextId(nextId + 1); // nextID값에 1을 더해준다.
        setNames(nextNames); // naems 값을 업데이트 한다.
        setInputText(""); // inputText를 비워준다.
    };
    const onKeyPress = e => {
        if (e.key === "Enter") onClick();
    };
    const onRemove = id => {
        const nextNames = names.filter(name => name.id !== id);
        setNames(nextNames);
    };

    const nameList = names.map(name => (
        <li key={name.id} onDoubleClick={() => onRemove(name.id)}>
            {name.text}
        </li>
    ));

    return (
        <>
            <input value={inputText} onChange={onChange} onKeyPress={onKeyPress} />
            <button onClick={onClick}>추가</button>
            <ul>{nameList}</ul>
        </>
    );
};

export default IterationSample;
