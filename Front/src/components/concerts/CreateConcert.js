import Axios from "../../apis/Axios"
import {  useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { Row, Col, Form, Button } from "react-bootstrap";


const CreateConcert=()=>{




    const[createdConcert,setCreatedConcert]=useState({
        performerId:-1,
        festivalId:-1

    });
      const [performers,setPerformers]=useState([]);
        const [festivals,setFestivals]=useState([]);
    var navigate = useNavigate();

    
    const getPerformers=()=>{
    Axios.get('/izvodjaci').
    then(res=>{
        console.log(res)
        setPerformers(res.data);

    }).catch(err=>{
        console.log(err);
    })

}

    const getFestivals=()=>{
    Axios.get('/festivali').
    then(res=>{
        console.log(res)
        setFestivals(res.data);

    }).catch(err=>{
        console.log(err);
    })

}

     useEffect(()=>{
        getFestivals();
        getPerformers();
    },[])

 



    const addConcert = () =>{

   
        const dto={
                   izvodjacId:createdConcert.performerId,
                   festivalId:createdConcert.festivalId


        }


        console.log(dto);

        Axios.post('/nastupi',dto).then(res =>{

        console.log(res);
        window.location.reload();

    }).catch(err =>{
        console.error("Status kod:", err.response.status);
        console.error("Poruka:", err.response.data);
         console.error("AxiosError:", err);

        alert("Doslo je do greske");
    })

}

  const onValueChange=(e)=>{
        const {name,value}=e.target;




        setCreatedConcert({ ...createdConcert,[name]:value});
        console.log(e.target.value);
    }  


    

         return (
            
            <Row >
                <Col></Col>
                <Col xs="12" sm="10" md="8">
          
                    <Form>
                        <Form.Group>
                            <Form.Label>Performer</Form.Label>
                            <Form.Control as='select' id="performerId" name="performerId" onChange={(e) => onValueChange(e)} >
                                 <option value={""}>Choose a Performer</option>
                                       {performers.map((performer, i) => (
                                        <option key={performer.id} value={performer.id}>{performer.ime}</option>
                                    ))}
                            </Form.Control>
                             <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Festival</Form.Label>
                            <Form.Control as='select' id="festivalId" name="festivalId" onChange={(e) => onValueChange(e)} >
                                 <option value={""}>Choose a Festival</option>
                                       {festivals.map((festival, i) => (
                                        <option key={festival.id} value={festival.id}>{festival.naziv}</option>
                                    ))}
                            </Form.Control>
                             <br />
                        </Form.Group>
                    <Button className="btn btn-primary btn-block" onClick={addConcert}>Add</Button>
                    </Form>
                </Col>
                <Col></Col>
          
            </Row>
    )   
}


export default CreateConcert;