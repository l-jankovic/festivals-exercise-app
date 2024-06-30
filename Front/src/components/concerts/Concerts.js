import { useEffect, useState,useCallback } from "react"
import { Button, Col, Row, Table,Form } from "react-bootstrap";
import Axios from "../../apis/Axios";
import ShowConcerts from "./ShowConcerts";
import CreateConcert from "./CreateConcert";
import { Role } from "../../services/auth";

const  Concerts = () =>{
    const [pageNo, setPageNo] = useState(0) // state za trenutni broj stranice
    const [maxPages, setMaxPages] = useState(0) // stat
    const [concerts,setConcerts]=useState([]);
    const [performers,setPerformers]=useState([]);
     const [festivals,setFestivals]=useState([]);
     const [searchParams, setSearchParams] = useState({
        performerId: "",
        festivalId:""
    });


    const getConcerts=useCallback(()=>{
        Axios.get(`/nastupi/page?pageNo=${pageNo}`,{
             Headers:{'Content-Type': 'application/json'
            },
            data: {},
            params:{
                izvodjacId:searchParams.performerId,
                festivalId:searchParams.festivalId
            }
        }).then(res =>{
            console.log(res)
            setMaxPages(res.headers["total-pages"])
            setConcerts(res.data)
        }).catch(err =>{
            console.log(err.data)
        })
    },[searchParams,pageNo])

    


    const getFestivals=()=>{
    Axios.get('/festivali').
    then(res=>{
        console.log(res)
        setFestivals(res.data);

    }).catch(err=>{
        console.log(err);
    })
}

    const getPerformers=()=>{
    Axios.get('/izvodjaci').
    then(res=>{
        console.log(res)
        setPerformers(res.data);

    }).catch(err=>{
        console.log(err);
    })
}


    useEffect(()=>{
      getConcerts()
      getPerformers()
      getFestivals()
    },[pageNo,getConcerts]);
    
    




 
      const handleChange=(e)=>{
        const {name,value}=e.target;




        setSearchParams({ ...searchParams,[name]:value});
        console.log(e.target.value);
    } 
/* 
    const handleSearch=()=>{
       getAssignments();
    }
 */
 





const renderConcerts = () =>{

    return concerts.map((concert,index)=>{
        
        return <ShowConcerts key={concert.id}  concert={concert}  ></ShowConcerts>
    })
} 



return (
      
    <Col>
        < Row><h1>Concerts</h1></Row>
                                <Row>
                    <Row style={{marginBottom:'100px'}}>
                    {Role()=='isAdmin'&&
                       <CreateConcert ></CreateConcert>         
}
                </Row>
                        <div container="container">
                            <Col>
    
                                <Form>
                                     <Form.Group>
                                    <Form.Label>Performer</Form.Label>
                                    <Form.Control as='select' id="performerId" name="performerId" onChange={handleChange} >
                                        <option value={""}>Choose a Performer</option>
                                            {performers.map((performer, i) => (
                                                <option key={performer.id} value={performer.id}>{performer.ime}</option>
                                            ))}
                                    </Form.Control>
                                    </Form.Group>
                                    <Form.Group controlId="festivalId">
                                        <Form.Label>Festival</Form.Label>
                                        <Form.Control as='select' name="festivalId"  onChange={handleChange} >
                                        <option value={""}>Choose a Festival</option>
                                       {festivals.map((festival, i) => (
                                        <option key={festival.id} value={festival.id}>{festival.naziv}</option>
                                        
                                    ))}
                                       </Form.Control>
                                    </Form.Group>
                           
                                </Form>
                                
                            </Col>
                        </div>
                    </Row>                  
                
               <Row><Col>
                <Table id="assigment-table"className="table-striped table-bordered table-hover"  >
                   <thead className="table-dark" >
                        <tr >
                            <th>Performer</th>
                            <th>Festival</th>
                            {Role()=='isAdmin'&&
                            <th></th>}
                         
                        </tr>
                    </thead>
                    <tbody >
                        {renderConcerts( )}
                    </tbody>                  
                </Table>
                </Col></Row>
                
                         <br/> <br/> <br/>
                    <div style={{paddingBottom:'5px'}} >
                    <span style={{ display: 'flex', justifyContent: "flex-end" }}>
                        <Button disabled={pageNo <= 0} onClick={() => setPageNo(pageNo - 1)} className="btn btn-info" style={{color:'white'}}>Previous</Button>
                        <Button disabled={maxPages === -1 || pageNo >= maxPages - 1} onClick={() => setPageNo(pageNo + 1)} className="btn btn-info" style={{color:'white'}}>Next</Button>
                    </span>
                </div>
              </Col>
       
    )








}



export default Concerts;