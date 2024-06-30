import Axios from "../../apis/Axios"
import {  useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { Row, Col, Form, Button } from "react-bootstrap";


const CreatePerformers=()=>{




    const[createdPerformer,setCreatedPerformer]=useState({
        name:"",
        genre:"",
        state:"",
        bandmembers:-1

    });







 

    const [isValid, setIsValid] = useState(false);

    const addPerformer = () =>{

   
        const dto={
                    ime:createdPerformer.name,
                    zanr:createdPerformer.genre,
                    drzavaPorekla:createdPerformer.state,
                    brojClanova:createdPerformer.bandmembers,
                  
                    


        }

    console.log(dto.sprintId)
        console.log(dto);

        Axios.post('/izvodjaci',dto).then(res =>{

        console.log(res);
        window.location.reload();

    }).catch(err =>{
      
         console.error("AxiosError:", err);
         console.error("Status kod:", err.response.status);
        console.error("Poruka:", err.response.data);

        alert("Doslo je do greske");
    })

}

  const onValueChange=(e)=>{
        const {name,value}=e.target;




        setCreatedPerformer({ ...createdPerformer,[name]:value});
        console.log(e.target.value);

  }




    function SubmitButton(){
    if (isValid){
      return <Button className="btn btn-primary btn-block" type="button" onClick={addPerformer}>create</Button>
    } else {
      return <Button  className="btn btn-primary btn-block" type="button" disabled>create</Button>
    };
  };
    

    const  validation=()=>{

        if(createdPerformer.genre === "" &&createdPerformer.name=== "" && createdPerformer.state==="" || createdPerformer.bandmembers===-1){
            setIsValid(false)
        }else{
        setIsValid(true)
        }
    }



         return (
            
            <Row >
                <Col></Col>
                <Col xs="12" sm="10" md="8">
          
                    <Form>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control
                                id="name" name="name" onChange={(e) => onValueChange(e)} onKeyUp={validation} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Genre</Form.Label>
                            <Form.Control id="genre" name="genre" onChange={(e) => onValueChange(e)} onKeyUp={validation} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>State</Form.Label>
                            <Form.Control id="state" name="state" onChange={(e) => onValueChange(e)}  onKeyUp={validation}/> <br />
                        </Form.Group>
                           <Form.Group>
                            <Form.Label>Band members</Form.Label>
                            <Form.Control id="bandmembers"  type="number"name="bandmembers" onChange={(e) => onValueChange(e)} onKeyUp={validation} /> <br />
                        </Form.Group>
                <SubmitButton></SubmitButton>
                    </Form>
                </Col>
                <Col></Col>
          
            </Row>
    )   
}



export default CreatePerformers;