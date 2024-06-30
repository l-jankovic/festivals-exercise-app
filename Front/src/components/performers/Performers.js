import { useEffect, useState,useCallback } from "react"
import { Col, Row, Table} from "react-bootstrap";
import Axios from "../../apis/Axios";
import ShowPerformers from "./ShowPerformers";
import CreatePerformers from "./CreatePerformers";
import { Role } from "../../services/auth";


const Performers = () =>{
   

    const [performers,setPerformers]=useState([]);



    const getPerformers=useCallback(()=>{
        Axios.get('/izvodjaci').then(res =>{
            console.log(res)
    
            setPerformers(res.data)
        }).catch(err =>{
            console.log(err.data)
        })
    },[])

    




    useEffect(()=>{
       getPerformers();
    },[]);
    
    





const renderPerformers = () =>{

    return performers.map((performer,index)=>{
        
        return <ShowPerformers key={performer.id}  performer={performer}  ></ShowPerformers>
    })
} 



return (
      
    <Col>
        <   Row><h1>Performers</h1></Row>
                                
                    <Row style={{marginBottom:'100px'}}>
                    {Role() =='isAdmin'&&
                       <CreatePerformers ></CreatePerformers>         
                }    </Row>
                       

                
               <Row><Col>
                <Table id="assigment-table"className="table-striped table-bordered table-hover"  >
                   <thead className="table-light" >
                        <tr >
                            <th>Name</th>
                            <th>Genre</th>
                            <th>State</th>
                            <th>Band Members</th>
                      
                     
                        </tr>
                    </thead>
                    <tbody >
                        {renderPerformers()}
                    </tbody>                  
                </Table>
                </Col></Row>
              </Col>
       
    )








}



export default Performers;