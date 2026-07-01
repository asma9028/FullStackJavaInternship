import React, { useState } from "react";

function BMICalculator() {
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");
  const [bmi, setBmi] = useState("");
  const [msg, setMsg] = useState("");
  const [image, setImage] = useState("");
  const [showResult, setShowResult] = useState(false);

  const calculateBMI = () => {
    if (!height || !weight) {
      alert("Please enter height and weight");
      return;
    }

    let bmiValue =
      weight / ((height / 100) * (height / 100));

    bmiValue = bmiValue.toFixed(2);

    setBmi(bmiValue);

    if (bmiValue < 18.5) {
      setMsg("Under Weight");
      setImage(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxlhq6ycRDZr6jgsYdoj1bMWK6o2OpeCU50w&s"
      );
    } else if (bmiValue < 25) {
      setMsg("Normal Weight");
      setImage(
        "https://www.shutterstock.com/image-vector/little-girl-on-scale-weighing-600nw-2313783423.jpg"
      );
    } else if (bmiValue < 30) {
      setMsg("Over Weight");
      setImage(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHR6zXy7dL_A4js_aQ1AOp6teENrwqxYCarw&s"
      );
    } else {
      setMsg("Obesity");
      setImage(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_47EimNX_gD3cjjuMGmtsfSa2t3V2e7vNYQ&s"
      );
    }

    setShowResult(true);
  };

  const calculateAgain = () => {
    setHeight("");
    setWeight("");
    setBmi("");
    setMsg("");
    setImage("");
    setShowResult(false);
  };

  return (
    <div>
      <center>
        <h1>BMI Calculator</h1>

        {!showResult ? (
          <>
            <input
              type="number"
              placeholder="Enter Height (cm)"
              value={height}
              onChange={(e) => setHeight(e.target.value)}
              style={{
                margin: "10px",
                height: "30px",
                width: "200px",
              }}
            />
            <br />

            <input
              type="number"
              placeholder="Enter Weight (kg)"
              value={weight}
              onChange={(e) => setWeight(e.target.value)}
              style={{
                margin: "10px",
                height: "30px",
                width: "200px",
              }}
            />
            <br />

            <button onClick={calculateBMI}>
              Calculate BMI
            </button>
          </>
        ) : (
          <>
            <h2>BMI: {bmi}</h2>
            <h3>{msg}</h3>

            <img
              src={image}
              alt={msg}
              width="250"
              height="250"
            />

            <br />
            <br />

            <button onClick={calculateAgain}>
              Calculate Again
            </button>
          </>
        )}
      </center>
    </div>
  );
}

export default BMICalculator;