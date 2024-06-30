import Axios from "../../apis/Axios"

import { useEffect, useState } from "react";




const ShowPerformers = (props) => {

    const [gigs, setGigs] = useState([]);

    const getGigs = () => {
        Axios.get('/nastupi')
            .then(res => {
                console.log(res)
                setGigs(res.data);
           
            })
            .catch(err => {
                console.log(err);
            });
    };

    useEffect(() => {
    
        getGigs();
    }, []);

    const onMouse = (e) => {
       
           let ime = e.currentTarget.firstChild.innerText;
           let count = 0;
          console.log(ime);
          gigs.forEach((gig)=>{
            if(gig.imeIzvodjaca==ime){
                count++;
            }
            console.log(gig.imeIzvodjaca)
          })

            alert(count );
        
    };

    return (
        <tr onClick={onMouse} >
            <td>{props.performer.ime}</td>
            <td>{props.performer.zanr}</td>
            <td>{props.performer.drzavaPorekla}</td>
            <td>{props.performer.brojClanova}</td>
        </tr>
    );
};

export default ShowPerformers;