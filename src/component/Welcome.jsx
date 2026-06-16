import React from 'react'

function Welcome({name,dept,year}) {
  const college = "KCE";
  return (
    <div>
    <h1>Welcome Asma Saedhiya ❤️ !!!</h1>
    <p>{name}, Department of {dept}, {year} year , {college}</p>
    </div>
  )
}

/*  (OR)
USING PROPS KEYWORD--for passing multiple arguments 
function Welcome(props) {
  const college = "KCE";
  return (
    <div>
    <h1>Welcome Asma Saedhiya ❤️ !!!</h1>
    <p>{props.name} , Department of {props.dept} , {props.year} year , {college}</p>
    </div>
  )
}*/
export default Welcome